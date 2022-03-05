package com.konman.clipper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konman.clipper.entity.ClipperOrder;

public interface ClipperOrderRepository extends JpaRepository<ClipperOrder, Integer> {

}
