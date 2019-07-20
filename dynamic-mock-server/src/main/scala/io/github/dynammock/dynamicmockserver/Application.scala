package io.github.dynammock.dynamicmockserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class Application

object WebApplication extends App {
  SpringApplication.run(classOf[Application]);
}