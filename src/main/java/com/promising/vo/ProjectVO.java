package com.promising.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name="PR_PROJECT")
public class ProjectVO {
	
	@Id
	private Long pno;
	@Column(nullable=false , length= 300)
	private String prTitle;
	@Column(nullable=false , length= 50)
	private String prCategory;
	@Column(nullable=false , length= 500)
	private String prIntro;
	@Column(nullable=false)
	private int prTargetMoney;
	@Column(nullable=true)
	private int prCurrentMoney;
	@Column(nullable=false)
	private Timestamp prStartdate;
	@Column(nullable=false)
	private Timestamp prEnddate;
	@Lob
	@Column(nullable=false)
	private String prContents;
	@Column(nullable=false , length= 100)
	private String prWriter;
	@Column(nullable=false , length= 500)
	private String prWriterintro;
	@Column(nullable=false , length= 1)
	private String prCheck; 		// 프로젝트 심사중/심사완료
	@Column(nullable=false , length= 1)
	private String prStatus;		// 프로젝트 진행/종료
	@Column( length=300)
	private String prOriName;
	@Column( length=300)
	private String prSysName;
	@CreationTimestamp
	private Timestamp regDate;
	@UpdateTimestamp
	private Timestamp updateDate;
	

}
