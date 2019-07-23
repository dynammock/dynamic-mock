package io.github.dynammock.dynamicmock.client.model

import scala.beans.BeanProperty
import java.util.HashMap
import java.util.Map
import io.github.dynammock.dynamicmock.client.model.enums.Method


class MockRequest() {
  @BeanProperty var method: Method = Method.ANY
  @BeanProperty var path: String = "/"
  @BeanProperty var headers: Map[String, String] = new HashMap()
  @BeanProperty var body: String = null

  def this(method: Method, path: String, headers: Map[String, String], body: String) = {
    this()
    this.method = method
    this.path = path
    this.headers = headers
    this.body = body
  }

  def method(method: Method): MockRequest = new MockRequest(method, path, headers, body)
  def path(path: String): MockRequest = new MockRequest(method, path, headers, body)
  def header(headerName: String, headerValue: String): MockRequest = {
    headers.put(headerName, headerValue)
    new MockRequest(method, path, headers, body)
  }
  def body(body: String): MockRequest = new MockRequest(method, path, headers, body)

  def header(headerName: String): String = headers.get(headerName)

}
