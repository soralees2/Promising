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
@SequenceGenerator(name="COMMENT_SEQ_GENERATOR",sequenceName = "COMMENT_SEQ" ,initialValue = 1,allocationSize = 1)
@Table(name="PR_COMMENT")
public class CommentVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
	private Long commentno;
	@Column(nullable=false , length=100)
	private String writer;
	@Column(nullable=false , length=4000)
	private String contents;
	@Column(nullable=false)
	private Long pr_parent;
	@CreationTimestamp
	private Timestamp regDate;
	@UpdateTimestamp
	private Timestamp updateDate;
}
