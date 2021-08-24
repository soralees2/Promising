package com.promising.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@SequenceGenerator(name="PAY_SEQ_GENERATOR",sequenceName = "PAY_SEQ" ,initialValue = 1,allocationSize = 1)
@Table(name="PR_PAY")
public class PayVO {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "PAY_SEQ_GENERATOR")
	private Long payno;
	@Column(nullable=false)
	private Long pno; // 부모 프로젝트 넘버 
	@Column(nullable=false , length= 1000)
	private String present;	// 상품 이름
	@Column(nullable=false , length= 1000)
	private String amount;	// 상품 갯수
	@Column(nullable=false , length= 1000)
	private String price; // 결제 금액
	@Column(nullable=false , length= 500)
	private String orderEmail; // 결제자 아이디 
	@Column( length=300)
	private String orderName;
	@Column(nullable=false , length= 20)
	private String orderPhone;
	@Column(nullable=false , length=10)
	private String orderPostcode;
	@Column(nullable=false , length=300)
	private String address1;
	@Column(nullable=false , length=200)
	private String address2;
	@CreationTimestamp
	private Timestamp regDate;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private ProjectVO project;
	
}
