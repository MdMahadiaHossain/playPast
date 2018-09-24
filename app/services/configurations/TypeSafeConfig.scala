package services.configurations

import java.net.URI

import com.typesafe.config.Config
import play.api.ConfigLoader


case class DomainUri(title: String, baseUri: URI)

object TypeSafeConfig {

  implicit val configLoader: ConfigLoader[DomainUri] = (config: Config, path: String) => {
    val conf = config.getConfig(path)

    DomainUri(conf.getString("title"), new URI(conf.getString("baseUri")))

  }
}


//implicit val configLoader: ConfigLoader[AppConfig] = new ConfigLoader[AppConfig] {
//  override def load(config: Config, path: String): AppConfig = {
//  val conf = config.getConfig(path)
//
//  AppConfig(conf.getString("title"), new URI(conf.getString("baseUri")))
//
//}
//
//}