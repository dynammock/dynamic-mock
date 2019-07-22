package io.github.dynammock.dynamicmock.server.repository

import org.springframework.data.jpa.repository.JpaRepository
import io.github.dynammock.dynamicmock.server.model.Rule

trait RuleRepository extends JpaRepository[Rule,String] {
  
}