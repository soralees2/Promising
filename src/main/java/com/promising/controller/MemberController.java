package com.promising.controller;

import java.security.Principal;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

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
	HttpSession httpSession;
	
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
	public void nameUpdate(@PathVariable("uname") String uname,@RequestBody MemberVO mvo,Model model,Principal principal) {
		System.out.println("10시");
		
		String originName =principal.getName();		
		MemberVO vo=repo.findById(originName).get(); //찐
		vo.setUname(uname);
		
		System.out.println("=========================username : " + vo.getUsername());
		System.out.println("vo getname"+vo.getUname());
		System.out.println("vo getname"+vo.getAddress1());
		System.out.println("=========================username : " + mvo.getUsername());
		System.out.println("mvo uname"+mvo.getUname());
		
		repo.save(vo);
		
//		return "redirect:/member/infoUpdate";
		
			}

	
	@RequestMapping(value="/uphoneUpdate/{modifyContact}",method = RequestMethod.POST)
	@ResponseBody
	public void emailUpdate(@PathVariable("modifyContact") String modifyContact,@RequestBody MemberVO mvo,Model model,Principal principal) {
		System.out.println("10시");
		
		String originName =principal.getName();		
		MemberVO vo=repo.findById(originName).get(); //찐
		vo.setUphone(modifyContact);
		
		repo.save(vo);
		
//		return "redirect:/member/infoUpdate";
		
			}
	
	
	
//	@RequestMapping(value="/deliveryModify/{obj.userName+obj.address1+obj.address2+obj.upostcode+obj.uphone}",method = RequestMethod.POST)
//	@ResponseBody
//	public void deliveryModify(@PathVariable("modifyContact") String o,Model model,Principal principal) {
//		System.out.println("10시");
//		
//		String originName =principal.getName();		
//		MemberVO vo=repo.findById(originName).get(); //찐
//	    vo.setAddress1(obj.)
//		vo.setUphone(modifyContact);
//		
//		repo.save(vo);
		
//		return "redirect:/member/infoUpdate";
	
		//	}
	
	
	
	@GetMapping("/qna")
	public void qna() {
		
		
		}
	
	
}
