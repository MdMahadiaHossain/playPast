//import javax.inject.{Inject, Singleton}
//
//import com.google.inject.Provider
//import play.api.http.DefaultHttpErrorHandler
//import play.api.mvc.Results._
//import play.api.mvc._
//import play.api.routing.Router
//import play.api.{Configuration, Environment, OptionalSourceMapper}
//
//import scala.concurrent.Future
//
//
//@Singleton
//class ErrorHandler @Inject()(env: Environment, config: Configuration,
//                             sourceMapper: OptionalSourceMapper,
//                             router: Provider[Router]) extends DefaultHttpErrorHandler(env, config, sourceMapper, router) {
//
//
//  override def onNotFound(request: RequestHeader, message: String): scala.concurrent.Future[play.api.mvc.Result] = {
//
//    Future.successful {
//      Ok(views.html.pageNotFound(s"${request.path} is not found"))
//    }
//  }
//
//}