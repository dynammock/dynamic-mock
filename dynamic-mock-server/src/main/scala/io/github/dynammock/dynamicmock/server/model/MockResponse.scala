package io.github.dynammock.dynamicmock.server.model

import scala.beans.BeanProperty
import java.util.HashMap
import java.util.Map

class MockResponse() {
  
  @BeanProperty var statusCode: Int = 200
  @BeanProperty var headers: Map[String, String] = new HashMap()
  @BeanProperty var body: String = null

  def this(statusCode: Int, headers: Map[String, String], body: String) = {
    this()
    this.statusCode = statusCode
    this.headers = headers
    this.body = body
  }

  def statusCode(statusCode: Int): MockResponse = new MockResponse(statusCode, headers, body)
  def header(headerName: String, headerValue: String): MockResponse = {
    headers.put(headerName, headerValue)
    new MockResponse(statusCode, headers, body)
  }
  def body(body: String): MockResponse = new MockResponse(statusCode, headers, body)

  def header(headerName: String): String = headers get headerName

}