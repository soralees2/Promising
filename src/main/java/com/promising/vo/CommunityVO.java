package com.promising.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="PR_COMMUNITY")
public class CommunityVO {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "COMMUNITY_SEQ")
	private int communityno;
	@Column(nullable=false , length=20)
	private String writer;
	@Column(nullable=false , length=50)
	private String title;
	@Column(nullable=false , length=1000)
	private String contents;
	@Column(nullable=false , length=1)
	private String secret;
	@Column(nullable=false)
	private int pr_parent;
	@Column(nullable=false , length=20)
	private Timestamp regdate;
}
