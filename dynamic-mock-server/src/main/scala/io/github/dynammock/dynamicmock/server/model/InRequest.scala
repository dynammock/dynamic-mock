package io.github.dynammock.dynamicmock.server.model

import scala.beans.BeanProperty
import org.springframework.context.annotation.Bean

@Bean
class InRequest(@BeanProperty var path: String, @BeanProperty var headers: Map[String, String]) {

  override def toString() = s"path:$path headers#:${headers.size}"

}