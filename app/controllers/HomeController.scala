package controllers

import javax.inject._

import play.api.Configuration
import play.api.mvc._
import services.configurations.DomainUri
import services.configurations.TypeSafeConfig._


@Singleton
class HomeController @Inject()(cc: ControllerComponents, config: Configuration) extends AbstractController(cc) {


  def index: Action[AnyContent] = Action {
    implicit request =>
      println(config.get[DomainUri]("play.domainUri"))

      Ok(views.html.index("Hello  everyOne"))

  }


}

