package io.github.dynammock.dynamicmock.server.model

import scala.beans.BeanProperty

class MockRule( 
    @BeanProperty val uuid: String,
    @BeanProperty val permanent: Boolean,
    @BeanProperty val request: MockRequest, 
    @BeanProperty val response: MockResponse,
    ) 