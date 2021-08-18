package com.promising.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.promising.vo.ProjectVO;
import com.promising.vo.QProjectVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface ProjectRepository extends JpaRepository<ProjectVO, Long>, QuerydslPredicateExecutor<ProjectVO>{
	
	@Query(value="select * from pr_project where pr_check not in ('N') and pr_status not in('F')", nativeQuery = true)
	List<ProjectVO> selectAll();
	
	@Query(value="select * from pr_project where pr_check not in ('N') and pr_status not in('F') order by pr_startdate desc", nativeQuery = true)
	List<ProjectVO> selectNewest();
	
	@Query(value="select * from pr_project where pr_check not in ('N') and pr_status not in('F') order by pr_enddate asc", nativeQuery = true)
	List<ProjectVO> selectClose();
	
	@Query(value="select pno, pr_category, pr_check, pr_enddate, pr_intro, pr_ori_name, pr_startdate, pr_status, pr_sys_name, pr_title, pr_writer,floor(pr_target_money/pr_current_money*100) as percent from pr_project where pr_check not in ('N') and pr_status not in('F') order by percent desc", nativeQuery = true)
	List<ProjectVO> selectPopular();
	
	@Query(value="select * from pr_project", nativeQuery = true)
	List<ProjectVO> selectList();

	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QProjectVO project = QProjectVO.projectVO;
		builder.and(project.pno.gt(0));
		
		if(type==null) {
			return builder;
		}
		switch(type) {
		case "t" :
			builder.and(project.prTitle.like("%"+keyword+"%"));
			break;
		
		}
		
		return builder;
	}
}
