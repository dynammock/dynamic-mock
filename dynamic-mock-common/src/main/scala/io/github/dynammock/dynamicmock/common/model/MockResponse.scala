package io.github.dynammock.dynamicmock.common.model

import scala.beans.BeanProperty
import java.util.HashMap
import java.util.Map

class MockResponse(@BeanProperty val statusCode: Int = 200, @BeanProperty val headers: Map[String, String] = new HashMap(),
                   @BeanProperty val body: String = null) extends Serializable {

  def statusCode(statusCode: Int): MockResponse = new MockResponse(statusCode, headers, body)
  def header(headerName: String, headerValue: String): MockResponse = {
    headers.put(headerName, headerValue)
    new MockResponse(statusCode, headers, body)
  }
  def body(body: String): MockResponse = new MockResponse(statusCode, headers, body)

  def header(headerName: String): String = headers get headerName

}