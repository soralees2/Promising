package com.promising.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promising.vo.CommunityVO;
import com.promising.vo.MemberVO;
import com.promising.vo.QnaVO;

public interface QnaRepository  extends JpaRepository<QnaVO, Long> {
	
	@Query("SELECT q FROM QnaVO q WHERE q.member= ?1 AND q.qnano > 0 ORDER BY q.qnano ASC")
	public List<QnaVO> getQnaOfMember(MemberVO member);
}
