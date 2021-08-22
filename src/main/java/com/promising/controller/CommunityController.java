package com.promising.controller;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.promising.repository.CommentRepository;
import com.promising.repository.CommunityRepository;
import com.promising.repository.ProjectRepository;
import com.promising.vo.CommentVO;
import com.promising.vo.CommunityVO;
import com.promising.vo.PageVO;

@Controller
@RequestMapping("/com")
public class CommunityController {
	
	@Autowired
	private ProjectRepository prepo;
	
	@Autowired
	private CommunityRepository repo;
	
	@Autowired
	private CommentRepository crepo;
	
	/*
	@PostMapping("/insert/{pno}")
	public String registerPost(@ModelAttribute("vo")CommunityVO vo, @PathVariable("pno") Long pno, Principal principal) {
		String userName = principal.getName();
		vo.setWriter(userName);
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("작성자1 : " + vo.getProject());
		repo.save(vo);
		System.out.println("ㅇㅇㅇㅇㅇㅇㅇ등록완료 ");
		return "redirect:/project/community/"+pno;
	}
	
	
	@PostMapping("/delete")
	public String delete(Long pno, Long communityno, PageVO vo, RedirectAttributes rttr) {

		System.out.println("삭제 pno ======================================= : " + pno);
		System.out.println("삭제 cno ======================================= : " + communityno);
		repo.deleteById(communityno);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/project/community/"+pno;
	}
	
	@PostMapping("/modify/{pno}")
	public String modifyPost(CommunityVO vo, @PathVariable("pno") Long pno, RedirectAttributes rttr ){
		
		System.out.println("========id 수정 : " +vo.getCommunityno());
		System.out.println("========id 수정 : " +vo.getContents());
		
		repo.findById(vo.getCommunityno()).ifPresent( origin ->{
			System.out.println(vo.getCommunityno());
			origin.setContents(vo.getContents());
			repo.save(origin);
		});	
		
		return "redirect:/project/community/"+pno;
	}
	
	
	
	//댓글 목록
	@GetMapping("/cmt/{communityno}")
	public ResponseEntity<List<CommentVO>> getReplies(
			@PathVariable("communityno")Long cno){
		System.out.println("=-===================댓글목록");
		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);
		return new ResponseEntity<>(getListByCommunity(vo),HttpStatus.OK );
	}
	
	@GetMapping("/cmtnum/{communityno}")
	public ResponseEntity<Integer> getCount(
			@PathVariable("communityno")Long cno){
		System.out.println("=-===================댓글목록2222222222");
		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);
		int num = crepo.commentCount(vo);
		return new ResponseEntity<>(num, HttpStatus.OK );
	}
	
	//댓글 추가
	@Transactional
	@PostMapping("/cmtadd/{communityno}")
	public ResponseEntity<List<CommentVO>> addReply(
			@PathVariable("communityno")Long cno, 
			@RequestBody CommentVO cmt){

		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);
		cmt.setCommunity(vo);
		
		crepo.save(cmt);		
		
		return new ResponseEntity<>(getListByCommunity(vo), HttpStatus.CREATED);
		
	}
	
	@Transactional
	@DeleteMapping("cmtdel/{commentno}/{communityno}")
	public ResponseEntity<List<CommentVO>> remove(
			@PathVariable("commentno")Long cmo,
			@PathVariable("communityno")Long cno
			){
		
		crepo.deleteById(cmo);
		
		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);

		return new ResponseEntity<>(getListByCommunity(vo), HttpStatus.OK);
		
	}

	
	private List<CommentVO> getListByCommunity(CommunityVO cmt)throws RuntimeException{
		return crepo.getCommentsOfCommunities(cmt);
	}
	*/
	
}
