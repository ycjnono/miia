/**
 * all Copyright 2018 MIIA
 */
package com.miia.notice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.miia.exception.SearchException;
import com.miia.exception.SendException;
import com.miia.mail.entity.Mail;
import com.miia.mail.entity.MailAuth;
import com.miia.mail.service.IMailStoreService;
import com.miia.notice.service.INoticeService;

/**
 * 集成通知服务接口实现
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Service
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	private IMailStoreService mailStoreService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.notice.service.INoticeService#sendMessage()
	 */
	@Override
	public Object sendMessage() throws SendException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.notice.service.INoticeService#listMailForder()
	 */
	@Override
	public Object listMailForder(int pageNo, int pageSize) throws SearchException {
		MailAuth auth = new MailAuth();
		auth.setAddress("ricardo@foxiange.cn");
		auth.setPassword("jiang8858@");
		Page<Mail> pageList = mailStoreService.pageList(auth, pageNo, pageSize);
		return pageList;
	}

}
