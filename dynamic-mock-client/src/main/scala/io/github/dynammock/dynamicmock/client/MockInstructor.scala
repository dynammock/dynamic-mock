/*

 Copyright 2019 Sumangal Mandal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.package io.github.dynammock.dynamicmock.server.server

*/

import java.util.ArrayList
import java.util.List

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