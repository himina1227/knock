package com.knock.bmt.admin.property

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@EnableConfigurationProperties(ApiConfiguration::class)
class PassPropertiesTest(
    @Autowired private val apiConfiguration: ApiConfiguration
) {

    @Test
    fun `properties 조회`() {
        assertThat(apiConfiguration.key).isEqualTo("api-access-key")
    }
}