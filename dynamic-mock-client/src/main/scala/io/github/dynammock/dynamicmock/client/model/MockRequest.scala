package io.github.dynammock.dynamicmock.client.model

import scala.beans.BeanProperty
import java.util.HashMap
import java.util.Map
import io.github.dynammock.dynamicmock.client.model.enums.Method

class MockRequest(@BeanProperty val method: Method = Method.ANY, @BeanProperty val path: String = "/",
                  @BeanProperty val headers: Map[String, String] = new HashMap(), @BeanProperty val body: String = null) extends Serializable {

  def method(method: Method): MockRequest = new MockRequest(method, path, headers, body)
  def path(path: String): MockRequest = new MockRequest(method, path, headers, body)
  def header(headerName: String, headerValue: String): MockRequest = {
    headers.put(headerName, headerValue)
    new MockRequest(method, path, headers, body)
  }
  def body(body: String): MockRequest = new MockRequest(method, path, headers, body)

  def header(headerName: String): String = headers get headerName

}