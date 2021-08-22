package com.promising.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.promising.repository.CommunityRepository;
import com.promising.vo.CommunityVO;
import com.promising.vo.ProjectVO;

@Service
public class CommunityService {

	@Autowired
	private CommunityRepository repo;
	
//	@Query("SELECT c FROM CommunityVO c WHERE c.project= ?1 AND c.communityno > 0 ORDER BY c.communityno DESC")
//	public List<CommunityVO> getCommunities(ProjectVO project);
	
	public List<CommunityVO> getCommunities(ProjectVO project){
		return repo.getCommunities(project);
	}
}
