package com.promising.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		List<ProjectVO> result = repo.selectAll();
		model.addAttribute("result", result);
		return "project/main";
	}
	
	@PostMapping("/newest")
	@ResponseBody
	public List<ProjectVO> newest (Model model, Principal principal) {
		System.out.println("최신순 요청");
		List<ProjectVO> result = repo.selectNewest();
		model.addAttribute("result", result);
		return result;
	}
	
	@PostMapping("/close")
	@ResponseBody
	public List<ProjectVO> close (Model model, Principal principal) {
		System.out.println("마감순 요청");
		List<ProjectVO> result = repo.selectClose();
		model.addAttribute("result", result);
		return result;
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
