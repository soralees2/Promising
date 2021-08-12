package com.promising.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@SequenceGenerator(name="MEMBERROLE_SEQ_GENERATOR",sequenceName = "MEMBERROLE_SEQ" ,initialValue = 1,allocationSize = 1)
@EqualsAndHashCode(of = "rno")
@ToString
@Table(name="MEMBERROLE")
public class MemberRoleVO {
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "MEMBERROLE_SEQ_GENERATOR")
	private Long rno;
	private String roleName;
}
