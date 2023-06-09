package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberPersistenceAdapterTest