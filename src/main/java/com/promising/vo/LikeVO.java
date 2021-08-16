package com.promising.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@SequenceGenerator(name="LIKE_SEQ_GENERATOR",sequenceName = "LIKE_SEQ" ,initialValue = 1,allocationSize = 1)
@Table(name="PR_LIKE")
public class LikeVO {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "LIKE_SEQ_GENERATOR")
	private Long likeno;
	@Column(nullable=false , length=100)
	private String liker;
	@Column(nullable=false)
	private Long pr_parent;
}
