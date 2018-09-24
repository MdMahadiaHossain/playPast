package controllers

import javax.inject.{Inject, Singleton}

import play.api.Play
import play.api.data.Form
import play.api.mvc._
import services.formServices.TestForm._

@Singleton
class TestFormController @Inject()(mc :MessagesControllerComponents) extends MessagesAbstractController(mc) {
  
  val postUrl: Call = routes.TestFormController.getDataforTestForm()

  def testFormPage: Action[AnyContent]=Action.apply{
    implicit messageRequest: MessagesRequest[AnyContent] =>
      Ok(views.html.testForm(testForm)(Persit.text)(postUrl))
  }

  def getDataforTestForm:Action[AnyContent]=Action{
   implicit messageRequest: MessagesRequest[AnyContent] =>
      testForm.bindFromRequest().fold (
        (hasError:Form[services.formServices.TestForm.Data])=> BadRequest(views.html.testForm(hasError)(Persit.text)(postUrl)),
        (success: services.formServices.TestForm.Data) => {
          println(success.text)
          Persit.text=success.text
          Redirect(routes.TestFormController.testFormPage())
        }

      )


  }



}

object Persit{
  var text:String="Default"
}