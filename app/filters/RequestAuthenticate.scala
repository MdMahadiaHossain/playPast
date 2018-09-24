package filters

import controllers.routes
import play.api.mvc._


trait RequestAuthenticate extends BaseController {


  def authenticate(f: Request[AnyContent] => Result): Action[AnyContent] = {
    Action {
      implicit request =>
        import filters.AuthenticateSetter.dbUserId
        if (request.session.get("session") != Option(dbUserId.get.toString)) {
          Redirect(routes.SessionSetterController.getFormDataForLogin())
        } else f(request)


    }
  }


}


