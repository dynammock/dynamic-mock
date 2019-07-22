package io.github.dynammock.dynamicmock.server.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.Column
import scala.beans.BeanProperty

@Entity
@Table(name = "RULE")
class Rule() {
  
  @BeanProperty @Id @Column(name = "UUID") var uuid: String = _
  @BeanProperty @Column(name = "IS_PERMANENT") var permanent: Boolean = _
  @BeanProperty @Column(name = "REQ_JSON") var request: String = _
  @BeanProperty @Column(name = "RES_JSON") var response: String = _
  
  def this(uuid:String, permanent:Boolean, request:String, response:String)= {
    this()
    this.uuid = uuid
    this.permanent = permanent
    this.request = request
    this.response = response
  }
  
}