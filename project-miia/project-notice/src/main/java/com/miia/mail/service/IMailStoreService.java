/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.miia.exception.SearchException;
import com.miia.mail.entity.Mail;
import com.miia.mail.entity.MailAuth;

/**
 * 邮件相关服务接口
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface IMailStoreService {

	/**
	 * 分页检索认证邮箱下邮件(mysql)
	 * 
	 * @param userAddress
	 * @return
	 */
	public Page<Mail> pageList(MailAuth auth, int pageNo, int pageSize) throws SearchException;

	/**
	 * 实时获取所有邮件
	 * 
	 * @param auth
	 * @return
	 */
	public List<Mail> listRealTime(MailAuth auth);
}
