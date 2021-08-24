package com.promising.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(exclude="community")
@SequenceGenerator(name="PROJECT_SEQ_GENERATOR",sequenceName = "PROJECT_SEQ" ,initialValue = 1,allocationSize = 1)
@Table(name="PR_PROJECT")
public class ProjectVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "PROJECT_SEQ_GENERATOR")
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
	private Date prStartdate;
	@Column(nullable=false)
	private Date prEnddate;
	@Lob
	@Column(nullable=false)
	private String prContents;
	@Column(nullable=false , length= 100)
	private String prWriter;
	@Column(nullable=false , length= 500)
	private String prWriterintro;
	@Column(nullable=false , length= 100)
	private String prPresentTitle;
	@Column(nullable=false , length= 1000)
	private String prPresentContents;
	@Column(nullable=false)
	private int prPresentPrice;
	
	@Column(nullable=false , length= 1)

	private String prStatus;		// 프로젝트 심사/진행/종료 N/I/F
	@Column( length=300)
	private String prOriName;
	@Column( length=300)
	private String prSysName;
	@CreationTimestamp
	private Timestamp regDate;
	@UpdateTimestamp
	private Timestamp updateDate;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="parent")
	private List<MemberRoleVO> roles;
	
	@JsonIgnore
	@OneToMany(mappedBy="project", fetch=FetchType.LAZY)
	private List<CommunityVO> community;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="project", fetch=FetchType.LAZY)
//	private List<PayVO> pay;
	
}
