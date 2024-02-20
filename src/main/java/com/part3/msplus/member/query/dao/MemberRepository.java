package com.part3.msplus.member.query.dao;

import com.part3.msplus.member.command.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
