package com.part3.msplus.member.domain.dao;

import com.part3.msplus.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
