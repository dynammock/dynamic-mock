package io.github.dynammock.dynamicmock.client

import java.util.List
import java.util.ArrayList
import org.springframework.web.client.RestTemplate
import io.github.dynammock.dynamicmock.client.model.MockRule

class MockInstructor(val url: String = null, val mockRules: List[MockRule] = new ArrayList()) {

  def url(url: String): MockInstructor = new MockInstructor(url, mockRules)

  def rule(mockRule: MockRule): MockInstructor = {
    mockRules add mockRule
    new MockInstructor(url, mockRules)
  }

  def rules(mockRules: List[MockRule]): MockInstructor = {
    mockRules addAll mockRules
    new MockInstructor(url, mockRules)
  }

  def rules(): List[MockRule] = mockRules

  def deploy(): Unit =
    {
      val restTemplate = new RestTemplate
      restTemplate.postForObject(url, mockRules, classOf[String]);
    }

}