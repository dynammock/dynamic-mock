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

@RestController
class InstructionController {

  @PostMapping(value = Array("/instruction"))
  def process(@RequestBody mockRules: List[MockRule]) = {
    println(mockRules.size())    
  }

}