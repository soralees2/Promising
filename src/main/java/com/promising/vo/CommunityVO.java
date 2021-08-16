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
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@SequenceGenerator(name="COMMUNITY_SEQ_GENERATOR",sequenceName = "COMMUNITY_SEQ" ,initialValue = 1,allocationSize = 1)
@Table(name="PR_COMMUNITY")
public class CommunityVO {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "COMMUNITY_SEQ_GENERATOR")
	private Long communityno;
	@Column(nullable=false , length=100)
	private String writer;
	@Column(nullable=false , length=200)
	private String title;
	@Column(nullable=false , length=4000)
	private String contents;
	@Column(nullable=false , length=1)
	private String secret;
	@Column(nullable=false)
	private int pr_parent;
	@CreationTimestamp
	private Timestamp regDate;
	@UpdateTimestamp
	private Timestamp updateDate;
}
