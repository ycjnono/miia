/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.sender;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.miia.base.AbstractSender;
import com.miia.exception.SendException;
import com.miia.mail.util.MailConst;

import lombok.extern.slf4j.Slf4j;

/**
 * 邮件发送器
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Slf4j
public class MailSender extends AbstractSender {


	private String host = "";
	private String user = "";
	private String password = "";

	/**
	 * 初始化配置项
	 */
	private void init() {
		host = properties.getProperty("system.mail.host");
		user = properties.getProperty("system.mail.user");
		password = properties.getProperty("system.mail.password");
		// 默认使用
		config.setFromAddress(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.base.AbstractSender#send()
	 */
	@Override
	public boolean send() throws SendException {
		this.init();
		Session session = this.createSession();
		Transport transport = this.createTransport(session);
		MimeMessage message = this.createMessage(session);
		try {
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			throw new SendException(e);
		}
		return false;
	}

	/**
	 * 获取邮件会话
	 * 
	 * @param properties
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
	 * 创建邮件传输对象
	 * 
	 * @param session
	 * @return
	 */
	private Transport createTransport(Session session) {
		Transport transport = null;
		try {
			transport = session.getTransport();
			transport.connect(user, password);
			return transport;
		} catch (MessagingException e) {
			log.error("creare transport error!", e);
			throw new SendException(e);
		}
	}

	/**
	 * 创建邮件
	 * 
	 * @return
	 */
	private MimeMessage createMessage(Session session) {

		// 创建邮件
		MimeMessage message = new MimeMessage(session);

		// 配置邮件属性
		try {
			// 发送人
			message.setFrom(new InternetAddress(config.getFromAddress(), config.getFromAddress(), config.getCharset()));
			// 增加收件人
			String[] toAddress = config.getToAddress();
			if (toAddress != null && toAddress.length > 0) {
				for (String address : toAddress) {
					message.setRecipient(MimeMessage.RecipientType.TO,
							new InternetAddress(address, address, config.getCharset()));
				}
			}

			// 增加抄送人
			String[] ccAddress = config.getCcAddress();
			if (ccAddress != null && ccAddress.length > 0) {
				for (String address : ccAddress) {
					message.setRecipient(MimeMessage.RecipientType.CC,
							new InternetAddress(address, address, config.getCharset()));
				}
			}

			// 密送人
			String[] bccAddress = config.getBccAddress();
			if (bccAddress != null && bccAddress.length > 0) {
				for (String address : bccAddress) {
					message.setRecipient(MimeMessage.RecipientType.BCC,
							new InternetAddress(address, address, config.getCharset()));
				}
			}

			// 主题
			message.setSubject(config.getSubject());

			// 正文
			message.setContent(config.getMessage(), config.getContentType());

			// 设置显示的发件时间,默认当前时间
			message.setSentDate(config.getSendDate() == null ? new Date() : config.getSendDate());

			// 保存配置
			message.saveChanges();

		} catch (UnsupportedEncodingException | MessagingException e) {
			log.error("configure mail attribute failure!", e);
			throw new SendException(e);
		}

		return message;
	}

}
