package com.promising.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.promising.vo.MemberVO;
import com.promising.vo.ProjectVO;
import com.promising.vo.QProjectVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface ProjectRepository extends JpaRepository<ProjectVO, Long>, QuerydslPredicateExecutor<ProjectVO>{
	
	@Query(value="SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT * FROM pr_project where pr_status not in ('N') and pr_status not in ('F')) A )WHERE RNUM > 0 AND RNUM <= 12", nativeQuery = true)
//	@Query("SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT * FROM pr_project where pr_check not in ('N') and pr_status not in('F')) A )WHERE RNUM > 0 AND RNUM <= 12")
	List<ProjectVO> selectAll();
	
	@Query(value="select * from pr_project where pr_status not in ('N') and pr_status not in ('F') order by pr_current_money desc", nativeQuery = true)
	Page<ProjectVO> selectPopular(Predicate makePredicate, Pageable page);
	
	@Query(value="select * from pr_project where pr_status not in ('N') and pr_status not in ('F') order by pr_startdate desc", nativeQuery = true)
	Page<ProjectVO> selectNewest(Predicate makePredicate, Pageable page);
	
	@Query(value="select * from pr_project where pr_status not in ('N') and pr_status not in ('F') order by pr_enddate asc", nativeQuery = true)
	Page<ProjectVO> selectClose(Predicate makePredicate, Pageable page);
	
	@Transactional
	@Modifying
	@Query(value="update pr_project set uname = :newName where uname = :before",nativeQuery=true)
	void updateProjectUname(@Param("before") String before, @Param("newName") String newName);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE PR_PROJECT P set P.PR_STATUS='I' WHERE P.PR_STATUS='N'", nativeQuery = true)
	void updatePrCheck();

	
	//내가 올린프로젝트 심사중
//		@Query("select c from pr_project c where c.pr_check not in ('Y') and c.pr_writer=:writer ")
//		List<ProjectVO> selectCheckingPro(String writer);
//
//		//내가 올린프로젝트 심사중
//		@Query("select c from pr_project c where c.pr_status not in ('F') and c.pr_writer=:writer ")
//		List<ProjectVO> selectProceedingPro(String writer);
//
//		//내가 올린프로젝트 완료된것
//		@Query("select c from pr_project c where pr_status not in ('I') and c.pr_writer=:writer ")
//		List<ProjectVO> selectFinishedPro(String writer);
	
	
		
		  //내가 올린프로젝트 심사중
		  
		  @Query(
		  value="select * from pr_project where pr_status in ('N') and pr_writer=:writer order by reg_date desc"
		  , nativeQuery = true) List<ProjectVO> selectCheckingPro(String writer);
		 
		  //내가 진행중인 프로젝트
		  
		  @Query(
		 value="select * from pr_project where pr_status in ('I') and pr_writer=:writer order by reg_date desc"
		  , nativeQuery = true) List<ProjectVO> selectProceedingPro(String writer);
		  
		  //내가 올린프로젝트 완료된것
		  
		 @Query(
		  value="select * from pr_project where pr_status in ('F') and pr_writer=:writer order by reg_date desc"
		  , nativeQuery = true) List<ProjectVO> selectFinishedPro(String writer);
		 


	
	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QProjectVO project = QProjectVO.projectVO;
		builder.and(project.pno.gt(0));
		
		System.out.println(type + " : " + keyword);

		if(type==null) {
			return builder;
		}
		switch(type) {
		case "게임" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "향수" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "디자인" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "지식" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "트렌드" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "출판" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "미디어" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "애완" :
			builder.and(project.prCategory.like("%"+keyword+"%"));
			break;
		case "I" :
			builder.and(project.prStatus.like("%"+keyword+"%"));
			break;
		case "N" :
			builder.and(project.prStatus.like("%"+keyword+"%"));
			break;
		case "F" :
			builder.and(project.prStatus.like("%"+keyword+"%"));
			break;
		case "제목" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		}

		return builder;
	}
	
	
	public default Predicate makePredicate2(String type, int keyword, int keyword2) {
		BooleanBuilder builder = new BooleanBuilder();
		QProjectVO project = QProjectVO.projectVO;
		builder.and(project.pno.gt(0));
		
		System.out.println(type + " : " + keyword + " : " + keyword2);

		if(type==null) {
			return builder;
		}
		
		switch(type) {
		case "0" :
			builder.and(project.prCurrentMoney.between(keyword, keyword2));
			break;
		case "1000001" :
			builder.and(project.prCurrentMoney.between(keyword, keyword2));
			break;
		case "10000001" :
			builder.and(project.prCurrentMoney.between(keyword, keyword2));
			break;
		case "50000001" :
			builder.and(project.prCurrentMoney.between(keyword, keyword2));
			break;
		case "100000001" :
			builder.and(project.prCurrentMoney.between(keyword, keyword2));
			break;
		}

		return builder;
		
	}

	
	

	
}
