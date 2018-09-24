package controllers

import javax.inject.Inject

import filters.AuthenticateSetter
import play.api.mvc._
import services.formServices.LogInForm.logInForm

class SessionSetterController @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {


  def getFormDataForLogin: Action[AnyContent] = Action {
    implicit request =>

      //extracting data from form request
      logInForm.bindFromRequest.fold(
        (formWithErrors) => BadRequest(views.html.logInForSession(formWithErrors)(AuthenticateSetter.postUrl)(request)),
        (y) => AuthenticateSetter.credentialAuthentication(Option(y.userId), Option(y.userName), Option(y.password))
      )

  }


}

