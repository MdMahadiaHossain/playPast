package filters

import controllers.routes
import play.api.mvc.{Call, Result, Results}

object AuthenticateSetter extends Results {

  private[filters] var dbUserId: Option[Long] = Option(123)


  private var dbUserName: Option[String] = Option("mahadia")


  private var dbPassword: Option[String] = Option("mahadi")


  val postUrl: Call = routes.SessionSetterController.getFormDataForLogin()

  def credentialAuthentication(userId: Option[Long], userName: Option[String], password: Option[String]): Result = {
    (userId, userName, password) match {
      case (x: Option[Long], y: Option[String], z: Option[String]) if x == dbUserId && y == dbUserName && z == dbPassword => Ok(views.html.index("Your new application is ready.")).withSession("session" -> dbUserId.get.toString)
      case _ => Redirect(routes.SessionSetterController.getFormDataForLogin())
    }
  }

}
