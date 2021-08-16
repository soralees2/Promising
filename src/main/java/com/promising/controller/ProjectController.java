package com.promising.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.promising.repository.ProjectRepository;
import com.promising.vo.CommunityVO;
import com.promising.vo.ProjectVO;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectRepository repo;
	
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
	@GetMapping("/complete")
	public void complete() {
		
	}

}
