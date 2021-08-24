package com.promising.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.promising.repository.CommentRepository;
import com.promising.vo.CommentVO;
import com.promising.vo.CommunityVO;

@Service
public class CommentService {

	
	@Autowired
	private CommentRepository repo;
	
//	@Query("SELECT r FROM CommentVO r WHERE r.community = ?1 AND r.commentno > 0 ORDER BY r.commentno DESC")
//	public List<CommentVO> getCommentsOfCommunities(CommunityVO community);
//	
//	@Query("SELECT count(*) FROM CommentVO c WHERE c.community= ?1")
//	public int commentCount(CommunityVO community);
//	
//	@Query("SELECT r FROM CommentVO r WHERE r.commentno = ?1 AND r.commentno > 0 ORDER BY r.commentno DESC")
//	public CommentVO getCmtOfCommunity(Long commnetno);
	
	public List<CommentVO> getCommentsOfCommunities(CommunityVO community){
		return repo.getCommentsOfCommunities(community);
	}
	public int commentCount(CommunityVO community) {
		return repo.commentCount(community);
	}
	public CommentVO getCmtOfCommunity(Long commnetno) {
		return repo.getCmtOfCommunity(commnetno);
	}
	
	}

