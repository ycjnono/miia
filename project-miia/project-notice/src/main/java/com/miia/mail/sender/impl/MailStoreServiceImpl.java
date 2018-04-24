/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.sender.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.miia.exception.SearchException;
import com.miia.mail.dao.IMailDao;
import com.miia.mail.entity.Mail;
import com.miia.mail.entity.MailAuth;
import com.miia.mail.service.IMailStoreService;
import com.miia.mail.util.MailConst;

import lombok.extern.log4j.Log4j;

/**
 * 邮件相关服务接口实现类
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Service
@Log4j
public class MailStoreServiceImpl implements IMailStoreService {
	
	@Autowired
	private IMailDao mailDao;

	@Value("${system.mail.host}")
	private String host;

	@Value("${system.mail.user}")
	private String user;

	@Value("${system.mail.password}")
	private String password;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.miia.mail.service.IMailStoreService#pageList(com.miia.mail.entity.
	 * MailAuth, int, int)
	 */
	@Override
	public Page<Mail> pageList(MailAuth auth, int pageNo, int pageSize) throws SearchException {
		Sort sort = new Sort(Direction.DESC, "createdTime");
		Pageable pageable = new PageRequest(pageNo, pageSize, sort);
		Page<Mail> pageList = this.mailDao.findAll(pageable);
		List<Mail> list = this.list(auth);
		if (pageList != null && list != null) {
			if (pageList.getTotalElements() !=  list.size()) {
				
			}
		}
		return null;
	}

	/**
	 * 列表查询
	 * 
	 * @param auth
	 * @return
	 */
	private List<Mail> list(MailAuth auth) {
		// 获取session
		Session session = this.createSession();
		List<Mail> list = new ArrayList<>();
		Folder folder = null;
		Store store = null;
		try {
			store = session.getStore();
			store.connect(auth.getAddress(), auth.getPassword());

			folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);

			Message[] messages = folder.getMessages();
			if (messages != null && messages.length > 0) {
				for (Message message : messages) {
					Mail mail = new Mail();
					mail.setFolder("INBOX");
					Address from = message.getFrom()[0];
					mail.setFromAddress(from.toString());
					mail.setSubject(message.getSubject());
					mail.setContent(String.valueOf(message.getContent()));
					list.add(mail);
				}
			}
			return list;
		} catch (MessagingException | IOException e) {
			throw new SearchException(e);
		} finally {
			destroy(folder, store);
		}
	}

	/**
	 * 创建邮件会话
	 * 
	 * @return
	 */
	private Session createSession() {
		Properties properties = new Properties();
		properties.setProperty(MailConst.SMTP, "smtp");
		properties.setProperty(MailConst.HOST, host);
		properties.setProperty(MailConst.AUTH, "true");
		Session session = Session.getInstance(properties);
		session.setDebug(true);
		return session;
	}

	/**
	 * 销毁Folder AND Store
	 * 
	 * @param folder
	 * @param store
	 */
	private void destroy(Folder folder, Store store) {
		try {
			if (folder != null) {
				folder.close(false);
				folder = null;
			}
			if (store != null) {
				store.close();
				store = null;
			}
		} catch (MessagingException e) {
			log.error("close folder or store error !", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.miia.mail.service.IMailStoreService#listRealTime(com.miia.mail.entity
	 * .MailAuth)
	 */
	@Override
	public List<Mail> listRealTime(MailAuth auth) {
		return this.list(auth);
	}

}
