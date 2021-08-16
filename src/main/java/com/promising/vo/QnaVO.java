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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@SequenceGenerator(name="QNA_SEQ_GENERATOR",sequenceName = "QNA_SEQ" ,initialValue = 1,allocationSize = 1)
@ToString
@EqualsAndHashCode(of="qnano")
@Table(name="PR_QNA")

public class QnaVO {   
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="QNA_SEQ_GENERATOR")
   private int qnano;
   @Column(nullable=false, length=50)
   private String qnacategory;
   
   @Column(nullable=false, length=100)
   private String writer;
   
   @Column(nullable=false, length=100)
   private String receiver;
   
   @Column(nullable=false, length=4000)
   private String contents;
   @CreationTimestamp
   private Timestamp regDate;
   @UpdateTimestamp
   private Timestamp updateDate;
   
   
}

