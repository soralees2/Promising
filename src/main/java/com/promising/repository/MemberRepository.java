package com.promising.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import org.springframework.stereotype.Repository;

import com.promising.vo.MemberVO;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, String> ,QuerydslPredicateExecutor<MemberVO>{
	
		Optional<MemberVO> findByUsername(String username);
		Optional<MemberVO> findByRealname(String realname);
		Optional<MemberVO> findByUname(String uname);
	
		
}
