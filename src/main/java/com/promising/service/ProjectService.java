package com.promising.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promising.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repo;
}
