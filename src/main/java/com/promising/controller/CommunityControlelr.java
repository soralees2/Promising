package com.promising.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@PostMapping("/add/{pno}")
//	public ResponseEntity<Void> addCommunity(@PathVariable("pno")Long pno, @RequestBody CommunityVO vo){
//		System.out.println("=========================pno : " + pno);
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}
	
	@PostMapping("/{pno}")
	//public ResponseEntity<List<CommunityVO>> addCommunity(@PathVariable("pno")Long pno, @RequestBody CommunityVO com){
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
}
