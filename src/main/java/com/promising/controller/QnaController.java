package com.promising.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promising.config.SecurityConfig;
import com.promising.repository.QnaRepository;
import com.promising.vo.MemberVO;
import com.promising.vo.QnaVO;

@RestController
@RequestMapping("/qna")
public class QnaController {

	
	
	@Autowired
	private QnaRepository qnaRepo;
	
	@Autowired
	private SecurityConfig security;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/home",method= {RequestMethod.GET})
	public void qna(Model model, Principal principal) {
		String writer =principal.getName();
		System.out.println(writer);
		 List<QnaVO> result = qnaRepo.selectQnaTome(writer);
		 System.out.println(result);
		 model.addAttribute("result", result);
		}
	
	
	
	
	@PostMapping("/{uname}")
	public ResponseEntity<List<QnaVO>> addQna(@PathVariable("uname")String uname, @RequestBody QnaVO qvo){
		System.out.println(qvo.getContents());
		System.out.println("-----------------" + uname);
		MemberVO vo = new MemberVO();
		vo.setUsername(uname);
		qvo.setMember(vo);
		qnaRepo.save(qvo);
		
		return new ResponseEntity<>(getListByMember(vo),HttpStatus.CREATED);
	}
	
	private List<QnaVO> getListByMember(MemberVO vo) throws RuntimeException{
		return qnaRepo.getQnaOfMember(vo);
	}
}