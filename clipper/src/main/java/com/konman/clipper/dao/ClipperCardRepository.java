package com.konman.clipper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konman.clipper.entity.ClipperCard;

public interface ClipperCardRepository extends JpaRepository<ClipperCard, Integer> {

}
