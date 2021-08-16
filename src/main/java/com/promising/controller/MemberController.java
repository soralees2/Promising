package com.promising.controller;

import java.security.Principal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public void mypage(Model model,Principal principal) {
	String userName =principal.getName();
		
		MemberVO result = repo.findByUsername(userName).get();
//		model.addAttribute("list",result);
		model.addAttribute("result", result);
		}
	
	

	@GetMapping("/infoUpdate")
	public void infoUpdate(Model model,Principal principal) {
		String userName =principal.getName();
		
		MemberVO result = repo.findByUsername(userName).get();
//		model.addAttribute("list",result);
		model.addAttribute("result", result);

		
		}
	
	
	@RequestMapping(value="/infoUpdate/{uname}",method = RequestMethod.POST)
	@ResponseBody
	public  String nameUpdate(@PathVariable("uname") String uname,@RequestBody MemberVO mvo,Model model,Principal principal) {
		
		MemberVO vo=repo.findById(uname).get();

		System.out.println("=========================username : " + mvo.getUsername());
		System.out.println(mvo.getUname());
		System.out.println(mvo.getAddress1());
		
		repo.save(vo);
		return "redirect:/member/infoUpdate";
	
		}
	
	
	
	
	@GetMapping("/qna")
	public void qna() {
		
		
		}
	
	
}
