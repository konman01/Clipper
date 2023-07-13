package com.konman.clipper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konman.clipper.entity.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer>{

}
