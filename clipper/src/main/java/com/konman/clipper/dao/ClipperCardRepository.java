package com.konman.clipper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.User;

public interface ClipperCardRepository extends JpaRepository<ClipperCard, Integer> {
	List<ClipperCard> findByUserAndStatus(User theUser, String email);
}
