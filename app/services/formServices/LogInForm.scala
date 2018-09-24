package services.formServices


import play.api.data.Forms._
import play.api.data.Form

object LogInForm {

  case class Data(userId: Long, userName: String, password: String)

  def logInForm =Form{
    mapping(
      "userId"-> longNumber,
      "userName"-> nonEmptyText,
      "password"-> nonEmptyText
    )(Data.apply)(Data.unapply)
  }

}
