package com.promising.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name="PROJECT_SEQ_GENERATOR",sequenceName = "PROJECT_SEQ" ,initialValue = 1,allocationSize = 1)
@Table(name="PR_PROJECTJOIN")
public class ProjectJoinVO {

	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "PROJECT_SEQ_GENERATOR")
	private Long pno;
	@Column(nullable=false , length= 50)
	private Long pno_parent;
	@Column(nullable=false , length= 500)
	private String joiner;
	@Column(nullable=false , length= 1000)
	private String amount;
	@CreationTimestamp
	private Timestamp regDate;
	
	
	
	
	
	
}
