package com.promising.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@GetMapping("/detail")
	public void detail(Model model) {
//		model.addAttribute("hello", "안녕하세요, 반갑습니다!");
	}
	@GetMapping("/payment")
	public void payment(Model model) {
//		model.addAttribute("hello", "안녕하세요, 반갑습니다!");
	}
	@GetMapping("/auth/upload1")
	public void upload1() {
		
	}
	@GetMapping("/auth/upload2")
	public void upload2() {
		
	}
}
