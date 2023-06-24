package com.knock.bmt.admin.property

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@EnableConfigurationProperties(ApiConfiguration::class)
class ApiConfigurationTest(
    @Autowired private val apiConfiguration: ApiConfiguration
) {

    @Test
    fun `properties 조회`() {
        AssertionsForClassTypes.assertThat(apiConfiguration.key).isEqualTo("api-access-key")
    }
}