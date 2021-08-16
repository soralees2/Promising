package com.promising.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.promising.repository.ProjectRepository;
import com.promising.vo.ProjectVO;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectRepository repo;

	@GetMapping("/detail")
	public void detail(Model model) {
//		model.addAttribute("hello", "안녕하세요, 반갑습니다!");
	}
	@GetMapping("/payment")
	public void payment(Model model) {
//		model.addAttribute("hello", "안녕하세요, 반갑습니다!");
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
	@GetMapping("/complete")
	public void complete() {
		
	}

}
