package com.promising.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.promising.repository.QnaRepository;
import com.promising.vo.MemberVO;
import com.promising.vo.QnaVO;

@Service
public class QnaService {

	@Autowired
	private QnaRepository repo;
//	
//	@Query(value="select * from pr_qna where member_username=?", nativeQuery = true)
//	public List<QnaVO> selectQnaTome(String writer);
//	@Query("SELECT q FROM QnaVO q WHERE q.member= ?1 AND q.qnano > 0 ORDER BY q.qnano ASC")
//	public List<QnaVO> getQnaOfMember(MemberVO member);

	public List<QnaVO> selectQnaTome(String writer){
		return repo.selectQnaTome(writer);
	}
	public List<QnaVO> getQnaOfMember(MemberVO member){
		return repo.getQnaOfMember(member);
	}
}
