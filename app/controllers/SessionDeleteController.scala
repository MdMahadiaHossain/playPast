package controllers

import javax.inject.Inject

import filters.{AuthenticateSetter, MessageRequestAuthentication}
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}
import services.formServices.LogInForm

class SessionDeleteController @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) with MessageRequestAuthentication{


   def deleteSession(): Action[AnyContent] = messageAuthenticate {
     implicit messageRequestHeader =>

       Ok(views.html.logInForSession(LogInForm.logInForm)(AuthenticateSetter.postUrl)).withNewSession

   }

}
