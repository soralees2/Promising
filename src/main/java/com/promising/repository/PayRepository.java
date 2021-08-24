package com.promising.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promising.vo.CommunityVO;
import com.promising.vo.PayVO;
import com.promising.vo.ProjectVO;

public interface PayRepository extends JpaRepository<PayVO, Long>{
	
//	@Query("SELECT c FROM PayVO c WHERE c.project= ?1 AND c.communityno > 0 ORDER BY c.communityno DESC")
//	public List<PayVO> getPayInfo(ProjectVO project);

}
