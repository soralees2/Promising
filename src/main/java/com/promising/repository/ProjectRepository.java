package com.promising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.promising.vo.ProjectVO;
import com.promising.vo.QProjectVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface ProjectRepository extends JpaRepository<ProjectVO, Long>, QuerydslPredicateExecutor<ProjectVO>{

	public default Predicate makePredicate() {
		BooleanBuilder builder = new BooleanBuilder();
		QProjectVO project = QProjectVO.projectVO;
		builder.and(project.pno.gt(0));
		
		return builder;
	}

}
