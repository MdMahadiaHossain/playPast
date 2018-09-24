package filters

import play.api.mvc._
import services.formServices.LogInForm


trait MessageRequestAuthentication extends MessagesBaseController {


  def messageAuthenticate(f: MessagesRequestHeader => Result): Action[AnyContent] = {
    Action {
      implicit messageRequestHeader =>
        import filters.AuthenticateSetter.dbUserId
        if (messageRequestHeader.session.get("session") != Option(dbUserId.get.toString)) {
          Ok(views.html.logInForSession(LogInForm.logInForm)(AuthenticateSetter.postUrl))
        } else f(messageRequestHeader)


    }
  }


}

