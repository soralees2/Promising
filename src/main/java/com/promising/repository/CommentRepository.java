package com.promising.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promising.vo.CommentVO;
import com.promising.vo.CommunityVO;
import com.promising.vo.ProjectVO;

public interface CommentRepository extends JpaRepository<CommentVO, Long>{

	@Query("SELECT r FROM CommentVO r WHERE r.community = ?1 " +
		       " AND r.commentno > 0 ORDER BY r.commentno DESC")
		public List<CommentVO> getCommentsOfCommunities(CommunityVO community);
	
	@Query("SELECT count(*) FROM CommentVO c WHERE c.community= ?1")
	public int commentCount(CommunityVO community);
	
}
