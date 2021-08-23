package com.promising.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promising.repository.MemberRepository;
import com.promising.repository.QnaRepository;
import com.promising.vo.MemberVO;
import com.promising.vo.QnaVO;

@RestController
@RequestMapping("/qna")
public class QnaController {

	
	@Autowired
	private QnaRepository qnaRepo;
	
	@Autowired
	private MemberRepository mRepo;
		
	@PostMapping("/{uname}")
	public ResponseEntity<List<QnaVO>> addQna(@PathVariable("uname")String uname, @RequestBody QnaVO qvo, Principal principal){
		System.out.println(qvo.getContents());
		System.out.println("-----------------" + uname); // 작성자 닉네임
		MemberVO vo = new MemberVO();
		
		MemberVO mvo = mRepo.findByUname(uname).get();
		String receiver = mvo.getUsername();
		vo.setUsername(receiver);
		System.out.println("ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ : " + principal.getName());
		qvo.setWriter(principal.getName());
		qvo.setMember(vo);
		qnaRepo.save(qvo);
		
		return new ResponseEntity<>(getListByMember(vo),HttpStatus.CREATED);
	}
	
	private List<QnaVO> getListByMember(MemberVO vo) throws RuntimeException{
		return qnaRepo.getQnaOfMember(vo);
	}
	
	// 커뮤니티 글 작성 
//	@PostMapping("/{username}")
//	public void addQna(@PathVariable("username")String uname, Principal principal, @RequestBody QnaVO qvo) {
//		String userName = principal.getName();
//
//		MemberVO result = mRepo.findByUsername(userName).get();
//		System.out.println(result.getUname());
//		
//		
////		qvo.setMember(result.getUname());
////		vo.setUsername(uname);
////		vo.setWriter(userName);
////		repo.save(vo);
//		
////		return "redirect:/project/community/"+pno;
//	}
}