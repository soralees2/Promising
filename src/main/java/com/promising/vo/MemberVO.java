package com.promising.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
@Table(name="MEMBER")
public class MemberVO {
	
		
		@Id
		private String username;
		
		@Column(nullable=false , length= 250)
		private String password;
		@Column(nullable=false , length= 30)
		private String uname;
		
		@Column(unique =true,nullable=false , length= 20)
		private String uphone;
		@Column(nullable=false , length=10)
		private String upostcode;
		@Column(nullable=false , length=300)
		private String address1;
		@Column(nullable=false , length=200)
		private String address2;
		@Column( length=300)
		private String oriName;
		@Column( length=300)
		private String sysName;
		@CreationTimestamp
		private Timestamp regdate;
		
		@UpdateTimestamp
		private Timestamp updatedate;
		
		@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
		@JoinColumn(name="member")
		private List<MemberRoleVO> roles;
		
}
