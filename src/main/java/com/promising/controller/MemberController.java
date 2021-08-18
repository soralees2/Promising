package com.promising.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.promising.repository.MemberRepository;
import com.promising.vo.MemberRoleVO;
import com.promising.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private PasswordEncoder pwEncoder;
	@Autowired
	private MemberRepository repo;
	@GetMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/signup")
	public void signup() {
		
	}
	@PostMapping("/signup")
	public String join(MemberVO vo) {
		MemberRoleVO role = new MemberRoleVO();
		role.setRoleName("BASIC");
		vo.setRoles(Arrays.asList(role));
		vo.setPassword(pwEncoder.encode(vo.getPassword()));
		
		repo.save(vo);
		return "redirect:/member/login";
	}
	
	@GetMapping("/mypage")
	public void mypage() {
		
		}
	
	

	@GetMapping("/infoUpdate")
	public void infoUpdate() {
		
		}
	
	@GetMapping("/qna")
	public void qna() {
		
		
		}
	
	@PostMapping("/idcheck/{username}")
	@ResponseBody
	public String idcheck(@PathVariable("username") String username) {
		if(repo.findByUsername(username).isPresent()) {
			return "exist";
		}else {
			return "can";
		}
	}
	@PostMapping("/unamecheck/{uname}")
	@ResponseBody
	public String unameCheck(@PathVariable("uname") String uname) {
	
		if(repo.findByUname(uname).isPresent()) {
			return "exist";
		}else {
			return "can";
		}
	}
}
