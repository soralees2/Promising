package com.promising.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promising.repository.CommunityRepository;
import com.promising.vo.CommunityVO;
import com.promising.vo.ProjectVO;

@RestController
@RequestMapping("/community")
public class CommunityControlelr {
	
	@Autowired
	private CommunityRepository repo;
	
	// 커뮤니티 글 작성
	@PostMapping("/{pno}")
	public ResponseEntity<List<CommunityVO>> addCommunity(@PathVariable("pno")Long pno, @RequestBody CommunityVO com){
		System.out.println("=========================pno : " + pno);
		System.out.println(com.getContents());
		System.out.println(com.getTitle());
		ProjectVO vo = new ProjectVO();
		vo.setPno(pno);
		com.setProject(vo);
		repo.save(com);
		
		return new ResponseEntity<>(getListByProject(vo),HttpStatus.CREATED);
	}
	
	private List<CommunityVO> getListByProject(ProjectVO vo) throws RuntimeException{
		return repo.getCommunitiesOfProject(vo);
	}
	
	// 커뮤니티 게시글 삭제
	@Transactional
	@DeleteMapping("/{pno}/{cno}")
	public ResponseEntity<List<CommunityVO>> removeCommunity(@PathVariable("pno")Long pno, @PathVariable("cno")Long cno){

		repo.deleteById(cno);
		ProjectVO vo = new ProjectVO();
		vo.setPno(pno);
		return new ResponseEntity<>(getListByProject(vo),HttpStatus.OK);
	}
	
	// 커뮤니티 내용 수정
	@Transactional
	@PutMapping("/{pno}")
	public ResponseEntity<List<CommunityVO>> modifyCommunity(@PathVariable("pno")Long pno, @RequestBody CommunityVO com){

		repo.findById(com.getCommunityno()).ifPresent(origin ->{
			origin.setContents(com.getContents());
			repo.save(origin);
		});
		
		ProjectVO pj = new ProjectVO();
		pj.setPno(pno);
		
		return new ResponseEntity<>(getListByProject(pj),HttpStatus.CREATED);
	}
	
	//커뮤니티 목록
	@GetMapping("/{pno}")
	public ResponseEntity<List<CommunityVO>> getCommunities(@PathVariable("pno")Long pno){
		ProjectVO vo = new ProjectVO();
		vo.setPno(pno);
		return new ResponseEntity<>(getListByProject(vo), HttpStatus.OK);
	}
	
	
}
