package com.konman.clipper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konman.clipper.entity.Account;

public interface AccountReposiroty extends JpaRepository<Account, Integer>{

}
