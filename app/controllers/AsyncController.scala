package controllers

import javax.inject._

import play.api.mvc._

import filters.RequestAuthenticate


@Singleton
class AsyncController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {


  def message: Action[AnyContent] = Action {
  	     request=>
  	     println(request.session.get("session"))

        Ok("Lets fuck Susan ")
      
  }


}
