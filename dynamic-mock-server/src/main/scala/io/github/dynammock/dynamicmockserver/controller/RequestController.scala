package io.github.dynammock.dynamicmockserver.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import java.util.Enumeration
import io.github.dynammock.dynamicmockserver.model.InRequest

@RestController
class RequestController {

  @RequestMapping(Array("/**"))
  def process(httpRequest: HttpServletRequest) = {
    println(processRequest(httpRequest).toString())
    "Hello World"
  }

  def processRequest(httpRequest: HttpServletRequest): InRequest = {

    def getHeaders(headerNames: Enumeration[String], headers: Map[String, String] = Map[String, String]()): Map[String, String] =
      if (!headerNames.hasMoreElements) headers
      else {
        val headerName = headerNames.nextElement
        getHeaders(headerNames, headers + (headerName -> (httpRequest getHeader headerName)))
      }

    new InRequest(httpRequest.getRequestURI, getHeaders(httpRequest.getHeaderNames))
  }

}