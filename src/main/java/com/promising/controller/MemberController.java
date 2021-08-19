package com.promising.controller;

import java.io.File;
import java.security.Principal;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.promising.config.SecurityConfig;
import com.promising.repository.MemberRepository;
import com.promising.vo.MemberRoleVO;
import com.promising.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	
	@Autowired
	private SecurityConfig security;
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	private HttpSession session;
	
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
	
	@PostMapping("/profileAttach")
	public String projectUpload(MemberVO vo,MultipartFile[] file,Principal principal,HttpServletRequest request) throws Exception {
		vo = repo.findByUsername(principal.getName()).get();

		
		String realPath = session.getServletContext().getRealPath("/");

		String relativePath ="src"+File.separator+"main"+File.separator+"resources"+File.separator +"static"+File.separator+"images"+File.separator+"profileUpload";
		System.out.println(relativePath+"/ 앞쪽이 리얼패스 ㅇㅇ");
		 File filesPath = new File(relativePath);
			if(!filesPath.exists()) {
				filesPath.mkdir();
			}
			for(MultipartFile tmp :file) {
				if(tmp.getSize()>0) {
				String oriName = tmp.getOriginalFilename();
				String sysName=UUID.randomUUID().toString().replaceAll("-","")+"_"+oriName;
				 vo.setOriName(oriName);
				 vo.setSysName(sysName);
				System.out.println(filesPath.getAbsolutePath()+" "+sysName+" "+oriName);
				tmp.transferTo(new File(filesPath.getAbsolutePath()+"/"+sysName));
				
				}
				}
			System.out.println(vo);
			repo.save(vo);
			return "redirect:/member/infoUpdate";
		
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

	
	@RequestMapping(value="/pwModify",method = RequestMethod.POST)
	@ResponseBody
	public void pwUpdate(@PathVariable("currPw") String currPw,@PathVariable("repw1") String repw1,@RequestBody MemberVO mvo,Model model,Principal principal) {
		System.out.println("10시");
		
		String nowPw= currPw;
		
		String originName =principal.getName();		
		MemberVO vo=repo.findById(originName).get(); //찐
		vo.setPassword(nowPw);
		vo.setPassword(pwEncoder.encode(vo.getPassword()));
		
	
		
		repo.save(vo);
		
//		return "redirect:/member/infoUpdate";
		
			}
	
	@GetMapping("/forget")
	public void forget() {
		
	}
}
