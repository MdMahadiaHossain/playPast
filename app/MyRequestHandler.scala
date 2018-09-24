package filters

import javax.inject.Inject

import akka.actor.{Actor, ActorSystem, Props}
import play.api.http.{DefaultHttpRequestHandler, HttpConfiguration, HttpErrorHandler, HttpFilters}
import play.api.mvc.Results._
import play.api.mvc.{DefaultActionBuilder, Handler, RequestHeader}
import play.api.routing.Router


class MyRequestHandler @Inject()(router: Router,
                               errorHandler: HttpErrorHandler,
                               configuration: HttpConfiguration,
                               filter: HttpFilters,
                               defaultActionBuilder: DefaultActionBuilder
                              )
  extends DefaultHttpRequestHandler(router, errorHandler, configuration, filter) {

  override def routeRequest(request: RequestHeader): Option[Handler] = {

    val actorSystem: ActorSystem = ActorSystem.apply("RequestHandlerActorSystem")
    val myActor = actorSystem.actorOf(Props[MyActor], "MyActor")
    myActor ! request.path

    request.path match {
      case "/" => router.routes.lift(request)
      case _ => Option(defaultActionBuilder.apply(Ok("path does not matches")))
    }
  }

}


class MyActor extends Actor {
  override def receive: Receive = {
    case g@_ => println(g)
  }

}