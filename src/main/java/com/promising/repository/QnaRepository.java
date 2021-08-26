package com.promising.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.promising.vo.MemberVO;
import com.promising.vo.QnaVO;

public interface QnaRepository  extends JpaRepository<QnaVO, Long> {

   //내가 받은프로젝트 문의
   @Query(value="select * from pr_qna where member_username=:member_username order by reg_date desc", nativeQuery = true)
   public List<QnaVO> selectQnaTome(String member_username);

   //내가 보낸 프로젝트 문의
   @Query(value="select * from pr_qna where writer=:member order by reg_date desc", nativeQuery = true)
   public List<QnaVO> selectQnaToOthers(String member);

   @Query("SELECT q FROM QnaVO q WHERE q.member= ?1 AND q.qnano > 0 ORDER BY q.qnano ASC")
   public List<QnaVO> getQnaOfMember(MemberVO member);
   

	@Transactional
	@Modifying
	@Query(value="update QnaVO set receiver = :newName where receiver = :before",nativeQuery=true)
	void updateQnaReceive(@Param("before") String before, @Param("newName") String newName);
}