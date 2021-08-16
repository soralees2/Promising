package com.promising.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promising.vo.ProjectVO;

public interface ProjectRepository extends JpaRepository<ProjectVO, Long> {

}
