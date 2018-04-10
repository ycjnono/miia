package com.miia.user.service;

import com.miia.base.exception.BaseException;
import com.miia.user.entity.User;
import com.miia.user.entity.UserDetail;

/**
 * 用户接口服务
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface IUserService {

	/**
	 * 获取用户详情
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 * @throws BaseException
	 */
	public UserDetail detail(String userId) throws BaseException;

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 * @throws BaseException
	 */
	public User regist(User user) throws BaseException;
	
	public User addDetail(String userId, UserDetail detail) throws BaseException;
}
