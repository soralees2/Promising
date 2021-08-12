package com.promising.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promising.vo.MemberVO;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, String> {


		Optional<MemberVO> findByUsername(String username);
}
