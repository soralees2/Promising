package com.promising.schedule;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.promising.repository.ProjectRepository;

@Component
public class Schedule {
	
	@Autowired
	private ProjectRepository repo;
	@Scheduled(cron = "0 0 9-18 ? * *")
	public void updatePrCheck() {
		repo.updatePrCheck();
}
}