package com.knock.bmt.app.property

import com.knock.bmt.admin.property.PassProperties
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@EnableConfigurationProperties(PassPropertiesTest::class)
class PassPropertiesTest(
    @Autowired private val passProperties: PassProperties
) {

    @Test
    fun `properties 조회`() {
        AssertionsForClassTypes.assertThat(passProperties.registration).isEqualTo("api-access-key")
    }
}