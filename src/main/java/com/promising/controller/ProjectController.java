package com.promising.controller;


import java.io.File;
import java.security.Principal;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;


import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.promising.repository.ProjectRepository;
import com.promising.vo.ProjectVO;



	
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private HttpSession session;
	@Autowired
	private ProjectRepository repo;
	
	//@GetMapping("/detail")
//	public void detail(Model model) {
//		model.addAttribute("hello", "안녕하세요, 반갑습니다!");

	
	@GetMapping("/detail/{pno}")
	public String detail(@PathVariable("pno") Long pno,Model model) {
		System.out.println("프로젝트 넘  : " + pno);
		ProjectVO vo= repo.findById(pno).get();
		//CommunityVO qvo= repo.findByCmt(pno).get();

		model.addAttribute("vo",vo);
		
		return "project/detail";
		

	}

	
	
//	@GetMapping("/detail/{bno}")
//	public String detail(@PathVariable("bno") Long bno, Model model) {
//		System.out.println(bno);
//		BoardVO vo= repo.findById(bno).get();
//		model.addAttribute("vo",vo);
//		System.out.println("bno : "+ bno);
//		return "board/detail";
//		
//	}
	
	
	@GetMapping("/payment")
	public void payment(Model model) {
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		List<ProjectVO> result = repo.findAll();
		model.addAttribute("result", result);
		
		return "project/main";
	}
	
	@GetMapping("/list")
	public void list() {
		
	}

	@GetMapping("/auth/upload1")
	public void upload1() {
		
	}
	@GetMapping("/auth/upload2")
	public void upload2() {
		
	}
	@GetMapping("/auth/upload3")
	public void upload3() {
		
	}
	@PostMapping("/auth/upload3")
	public String projectUpload(ProjectVO vo,MultipartFile[] file,Principal principal,String prStartday,String prEndday,String targetmoney,String presentprice) throws Exception {
		vo.setPrWriter(principal.getName());
		java.sql.Date prStartdate =java.sql.Date.valueOf(prStartday);
		java.sql.Date prEnddate =java.sql.Date.valueOf(prEndday);
		
		vo.setPrStartdate(prStartdate);
		vo.setPrEnddate(prEnddate);
		vo.setPrCheck("N");
		vo.setPrStatus("I");
		System.out.println(targetmoney+" "+presentprice);
		vo.setPrTargetMoney(Integer.parseInt(targetmoney));
		vo.setPrPresentPrice(Integer.parseInt(presentprice));
		String realPath = session.getServletContext().getRealPath("files");
		 File filesPath = new File(realPath);
			if(!filesPath.exists()) {
				filesPath.mkdir();
			}
			for(MultipartFile tmp :file) {
				if(tmp.getSize()>0) {
				String oriName = tmp.getOriginalFilename();
				String sysName=UUID.randomUUID().toString().replaceAll("-","")+"_"+oriName;
				 vo.setPrOriName(oriName);
				 vo.setPrSysName(sysName);
				System.out.println(filesPath.getAbsolutePath()+" "+sysName+" "+oriName);
				tmp.transferTo(new File(filesPath.getAbsolutePath()+"/"+sysName));
				
				}
				}
			System.out.println(vo);
			repo.save(vo);
			return "redirect:/project/complete";
	}
	@GetMapping("/complete")
	public void complete() {
		
	}

}
