package com.promising.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.promising.vo.ProjectVO;
import com.promising.vo.QProjectVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface ProjectRepository extends JpaRepository<ProjectVO, Long>, QuerydslPredicateExecutor<ProjectVO>{
	
	@Query(value="SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT * FROM pr_project where pr_check not in ('N') and pr_status not in('F')) A )WHERE RNUM > 0 AND RNUM <= 12", nativeQuery = true)
//	@Query("SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT * FROM pr_project where pr_check not in ('N') and pr_status not in('F')) A )WHERE RNUM > 0 AND RNUM <= 12")
	List<ProjectVO> selectAll();
	
	@Query(value="select * from pr_project where pr_check not in ('N') order by pr_current_money desc", nativeQuery = true)
	Page<ProjectVO> selectPopular(Predicate makePredicate, Pageable page);
	
	@Query(value="select * from pr_project where pr_check not in ('N') order by pr_startdate desc", nativeQuery = true)
	Page<ProjectVO> selectNewest(Predicate makePredicate, Pageable page);
	
	@Query(value="select * from pr_project where pr_check not in ('N') order by pr_enddate asc", nativeQuery = true)
	Page<ProjectVO> selectClose(Predicate makePredicate, Pageable page);
	
	@Query(value="select * from pr_project", nativeQuery = true)
	Page<ProjectVO> selectList(Predicate makePredicate, Pageable page);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE PR_PROJECT P set P.PR_CHECK='Y' WHERE P.PR_CHECK='N'", nativeQuery = true)
	void updatePrCheck();

	//내가 올린프로젝트 심사중
	@Query(value="select * from pr_project where pr_check not in ('Y') and pr_writer='writer' ", nativeQuery = true)
	List<ProjectVO> selectCheckingPro(String writer);

	//내가 올린프로젝트 심사중
	@Query(value="select * from pr_project where pr_status not in ('F') and pr_writer='writer' ", nativeQuery = true)
	List<ProjectVO> selectProceedingPro(String writer);

	//내가 올린프로젝트 완료된것
	@Query(value="select * from pr_project where pr_status not in ('I') and pr_writer='writer' ", nativeQuery = true)
	List<ProjectVO> selectFinishedPro(String writer);

	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QProjectVO project = QProjectVO.projectVO;
		builder.and(project.pno.gt(0));

		if(type==null) {
			return builder;
		}
		switch(type) {
		case "g" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "p" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "d" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "k" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "t" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "b" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "m" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		case "a" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		}

		return builder;
	}

	

	
}
