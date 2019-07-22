package io.github.dynammock.dynamicmock.server.service

import scala.beans.BeanProperty
import io.github.dynammock.dynamicmock.server.model.MockRule
import io.github.dynammock.dynamicmock.server.repository.RuleRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import io.github.dynammock.dynamicmock.server.model.Rule
import java.util.List
import com.fasterxml.jackson.databind.ObjectMapper
import scala.collection.JavaConverters
import java.text.Normalizer.Form
import io.github.dynammock.dynamicmock.server.model.MockRequest
import io.github.dynammock.dynamicmock.server.model.MockResponse
import java.util.ArrayList
import java.util.stream.Collectors
import java.util.Optional

@Service
class RuleService() {

  @Autowired @BeanProperty val ruleRepository: RuleRepository = null

  def createRule(mockRule: MockRule): Unit = {
    val rule = new Rule(
      mockRule.getUuid(),
      mockRule.getPermanent(),
      new ObjectMapper().writeValueAsString(mockRule.getRequest()),
      new ObjectMapper().writeValueAsString(mockRule.getResponse()))
    ruleRepository.save(rule)
  }

  def createRules(mockRules: List[MockRule]): Unit = {
    mockRules.stream().forEach(mockRule => createRule(mockRule))
  }

  def getAllRules(): List[MockRule] = {
    val mockRules: List[MockRule] = new ArrayList
    ruleRepository.findAll().stream().forEach(rule => mockRules add ruleToMockRule(rule));
    mockRules
  }

  def ruleToMockRule(rule: Rule): MockRule = new MockRule(
    rule.getUuid(),
    rule.getPermanent(),
    new ObjectMapper().readValue(rule.getRequest(), classOf[MockRequest]),
    new ObjectMapper().readValue(rule.getResponse(), classOf[MockResponse]))

  def getRule(uuid: String): MockRule = {
    val rule = ruleRepository findById uuid
    if (rule.isPresent) ruleToMockRule(rule.get)
    else null
  }

  def removeRule(uuid: String): Unit = ruleRepository deleteById uuid

  def removeAllRules(): Unit = ruleRepository.deleteAll

}