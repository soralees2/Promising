package com.promising.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.promising.vo.CommentVO;
import com.promising.vo.CommunityVO;
import com.promising.vo.ProjectVO;


public interface CommunityRepository extends JpaRepository<CommunityVO, Long> {
	

	@Query("SELECT c FROM CommunityVO c WHERE c.project= ?1 AND c.communityno > 0 ORDER BY c.communityno DESC")
	public List<CommunityVO> getCommunities(ProjectVO project);
	
//	@Query("SELECT c FROM CommentVO c WHERE c.project= ?1 AND c.community= ?2 AND c.commentno > 0 ORDER BY c.commentno DESC")
//	public List<CommentVO> getCommets(ProjectVO project, CommunityVO community);
//	@Query("select c from community c where c.project_pno = :pno")
//  public List<CommunityVO> methodName(@Param("pno") Long pno);	
//	@Query("select m from Member m where m.username = :username and m.age = :age") 
//	List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
