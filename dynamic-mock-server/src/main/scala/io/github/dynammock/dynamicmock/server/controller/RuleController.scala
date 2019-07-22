package io.github.dynammock.dynamicmock.server.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import java.util.Enumeration
import java.util.stream.Collectors
import io.github.dynammock.dynamicmock.server.model.MockRequest
import io.github.dynammock.dynamicmock.server.model.MockResponse
import io.github.dynammock.dynamicmock.server.model.MockRule
import io.github.dynammock.dynamicmock.server.model.enums.Method
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import javax.persistence.JoinColumn
import javax.persistence.GeneratedValue
import javax.persistence.Entity
import scala.beans.BeanProperty
import javax.persistence.Id
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.List
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.dynammock.dynamicmock.server.service.RuleService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
class RuleController {

  @Autowired @BeanProperty val ruleService: RuleService = null

  @PostMapping(Array("/rules"))
  def process(@RequestBody mockRules: List[MockRule]) = ruleService.createRules(mockRules)

  @DeleteMapping(Array("/rules"))
  def deleteAllRules() = ruleService.removeAllRules()

  @DeleteMapping(Array("/rules/{uuid}"))
  def deleteRule(@PathVariable("uuid") uuid: String) = ruleService.removeRule(uuid)

  @GetMapping(Array("/rules"))
  def getAllRules() = ruleService.getAllRules()
  
  @GetMapping(Array("/rule/{uuid}"))
  def getRule(@PathVariable("uuid") uuid: String) = ruleService.getRule(uuid)

}