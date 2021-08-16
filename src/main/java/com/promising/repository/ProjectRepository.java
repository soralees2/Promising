package com.promising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.promising.vo.ProjectVO;

public interface ProjectRepository extends JpaRepository<ProjectVO, Long> {
=======
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
>>>>>>> 1c05b453193e67b87cef25a0fd3a8d72affa737e

}
