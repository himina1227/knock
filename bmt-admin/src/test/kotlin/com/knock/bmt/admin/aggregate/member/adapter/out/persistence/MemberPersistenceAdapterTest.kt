package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import com.knock.bmt.admin.aggregate.member.domain.Member
import com.knock.bmt.admin.aggregate.member.domain.vo.Password
import com.knock.bmt.admin.config.BMTConfiguration
import com.knock.bmt.admin.config.PersistentConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ContextConfiguration

@DataJpaTest
@ContextConfiguration(classes = [PersistentConfig::class, MemberRepository::class, MemberMapper::class, MemberPersistenceAdapter::class, BMTConfiguration::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberPersistenceAdapterTest(@Autowired val memberPersistenceAdapter: MemberPersistenceAdapter,
                                   @Autowired val memberRepository: MemberRepository,
                                   @Autowired val memberMapper: MemberMapper,
                                   @Autowired val passwordEncoder: PasswordEncoder) {

    @Test
    fun 이메일_중복시_true를_리턴한다() {
        val member = Member(
            email = "himina1227@gmail.com",
            name = "김낙겸",
            password = Password("1234qwer!@#")
        )
        memberRepository.save(memberMapper.toEntity(member, passwordEncoder));
        assertThat(memberPersistenceAdapter.duplicateByEmail("himina1227@gmail.com")).isEqualTo(true)
    }

    @Test
    fun 회원가입시_저장한_값을_올바르게_반환한다() {
        val member = Member(
            email = "himina1227@gmail.com",
            name = "김낙겸",
            password = Password("1234qwer!@#")
        )
        val newMember = memberPersistenceAdapter.signUp(member)
        assertThat(newMember.email == "himina1227@gmail.com")
    }

    @Test
    fun 탈퇴시_회원의_disabled_컬럼은_true를_반환한다() {
        val member = Member(
            email = "himina1227@gmail.com",
            name = "김낙겸",
            password = Password("1234qwer!@#")
        )
        val newMember = memberRepository.save(memberMapper.toEntity(member, passwordEncoder))
        assertThat(!newMember.disabled)
        memberPersistenceAdapter.leave(newMember.id!!)
        assertThat(newMember.disabled)
    }
}