package io.github.dynammock.dynamicmock.server.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import java.util.Enumeration
import io.github.dynammock.dynamicmock.server.model.InRequest
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

@RestController
class RequestController {

  @RequestMapping(Array("/mock/**"))
  def process(httpRequest: HttpServletRequest) = {
    println(processRequest(httpRequest).toString())
  }

  def processRequest(httpRequest: HttpServletRequest): InRequest = {
    def getHeaders(headerNames: Enumeration[String], headers: Map[String, String] = Map[String, String]()): Map[String, String] =
      if (!headerNames.hasMoreElements) headers
      else {
        val headerName = headerNames.nextElement
        getHeaders(headerNames, headers + (headerName -> (httpRequest getHeader headerName)))
      }

    def getBody(httpRequest: HttpServletRequest): String = httpRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()))

    new InRequest(httpRequest.getRequestURI, getHeaders(httpRequest.getHeaderNames))
  }

}