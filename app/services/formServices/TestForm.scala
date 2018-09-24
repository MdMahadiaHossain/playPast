package services.formServices

import play.api.data.Form
import play.api.data.Forms._

object TestForm {

  case class Data(text:String)

  val testForm=Form{
    mapping(
      "text"->nonEmptyText
    )(Data.apply)(Data.unapply)
  }

}
