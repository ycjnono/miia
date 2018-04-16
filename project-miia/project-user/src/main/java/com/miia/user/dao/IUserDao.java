package com.miia.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miia.user.entity.User;

/**
 * 用户dao交互
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Repository
public interface IUserDao extends JpaRepository<User, String> {
	
	

}
