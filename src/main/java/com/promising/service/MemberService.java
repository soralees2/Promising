package com.promising.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promising.repository.MemberRepository;
import com.promising.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberRepository repo;
	
//	Optional<MemberVO> findByUsername(String username);
//	Optional<MemberVO> findByRealname(String realname);
//	Optional<MemberVO> findByUname(String uname);
	
	
	public Optional<MemberVO> findByUsername(String username){
		return repo.findByUsername(username);
	}
	public Optional<MemberVO> findByRealname(String realname){
		return repo.findByRealname(realname);
	}
	public Optional<MemberVO> findByUname(String uname){
		return repo.findByUname(uname);
	}
}
