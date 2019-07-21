import io.github.dynammock.dynamicmockcore.model.MockRequest
import io.github.dynammock.dynamicmockcore.model.MockRule
import io.github.dynammock.dynamicmockcore.model.MockResponse
import io.github.dynammock.dynamicmockcore.model.enums.Method

object Test extends App {

  val mockRequest = new MockRequest().method(Method.GET).path("/ok").header("accept", "application/xml")
  val mockResponse = new MockResponse().statusCode(404).header("context-type", mockRequest.header("accept")).body("<xml>ok</xml>")
  val rule1 = new MockRule(mockRequest, mockResponse, true, "123-456")
  val rule2 = new MockRule(mockRequest, mockResponse, false, "123-456-789")
  new MockInstructor().url("http://localhost:8080/instruction").rule(rule1).rule(rule2).deploy()

}