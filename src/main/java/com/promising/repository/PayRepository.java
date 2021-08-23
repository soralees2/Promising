package com.promising.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promising.vo.PayVO;

public interface PayRepository extends JpaRepository<PayVO, Long>{

}
