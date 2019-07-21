package io.github.dynammock.dynamicmock.common.model

import scala.beans.BeanProperty

class MockRule(@BeanProperty val request: MockRequest, @BeanProperty val response: MockResponse,
               @BeanProperty val permanent: Boolean, @BeanProperty val uuid: String) extends Serializable {

}