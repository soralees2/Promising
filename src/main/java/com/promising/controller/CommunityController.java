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
import com.promising.repository.MemberRepository;
import com.promising.repository.ProjectRepository;
import com.promising.vo.CommentVO;
import com.promising.vo.CommunityVO;
import com.promising.vo.MemberVO;
import com.promising.vo.PageVO;
import com.promising.vo.ProjectVO;

@Controller
@RequestMapping("/com")
public class CommunityController {
	
	@Autowired
	private ProjectRepository prepo;
	
	@Autowired
	private CommunityRepository repo;
	
	@Autowired
	private CommentRepository crepo;
	
	@Autowired
	private MemberRepository mrepo;

	
	// 커뮤니티 글 작성 
	@PostMapping("/insert/{project}")
	public String registerPost(@ModelAttribute("vo")CommunityVO vo, @PathVariable("project") Long pno, Principal principal) {
		
		String userName = principal.getName();
		vo.setWriter(userName);
		repo.save(vo);
		
		return "redirect:/project/community/"+pno;
	}
	
	// 커뮤니티 글 수정
	@PostMapping("/modify/{pno}")
	public String modifyPost(CommunityVO vo, @PathVariable("pno") Long pno ){
		
		repo.findById(vo.getCommunityno()).ifPresent( origin ->{
			System.out.println(vo.getCommunityno());
			origin.setContents(vo.getContents());
			repo.save(origin);
		});	
		
		return "redirect:/project/community/"+pno;
	}
	// 커뮤니티 글 삭제
	@PostMapping("/delete/{pno}")
	public String delete(Long communityno, @PathVariable("pno") Long pno) {
		repo.deleteById(communityno);
		return "redirect:/project/community/"+pno;
	}
	
	// 댓글 목록 
	@GetMapping("/cmt/{communityno}")
	public ResponseEntity<List<CommentVO>> getReplies(@PathVariable("communityno")Long cno){
		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);
		return new ResponseEntity<>(getListByCommunity(vo),HttpStatus.OK);
	}
	
	
	//댓글 추가
	@Transactional
	@PostMapping("/cmtadd/{communityno}")
	public ResponseEntity<List<CommentVO>> addReply(@PathVariable("communityno")Long cno, @RequestBody CommentVO cmt, Principal principal){

		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);
		cmt.setCommunity(vo);
		cmt.setWriter(principal.getName());
		crepo.save(cmt);		
		
		return new ResponseEntity<>(getListByCommunity(vo), HttpStatus.CREATED);
		
	}
	
	// 댓글 삭제
	@Transactional
	@DeleteMapping("cmtdel/{commentno}/{communityno}")
	public ResponseEntity<List<CommentVO>> remove(@PathVariable("commentno")Long cmo,@PathVariable("communityno")Long cno){
		crepo.deleteById(cmo);
		CommunityVO vo = new CommunityVO();
		vo.setCommunityno(cno);

		return new ResponseEntity<>(getListByCommunity(vo), HttpStatus.OK);
	}
		
	private List<CommentVO> getListByCommunity(CommunityVO cmt)throws RuntimeException{
		return crepo.getCommentsOfCommunities(cmt);
	}

	
}
