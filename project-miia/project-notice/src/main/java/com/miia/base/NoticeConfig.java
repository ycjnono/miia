/**
 * all Copyright 2018 MIIA
 */
package com.miia.base;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 通知配置类
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeConfig {

	/**
	 * 收信人
	 */
	private String[] toAddress;

	/**
	 * 发信人
	 */
	private String fromAddress;
	
	/**
	 * 发信人昵称
	 */
	private String nickname;
	
	/**
	 * 抄送人
	 */
	private String[] ccAddress;
	
	/**
	 * 密送人
	 */
	private String[] bccAddress;
	
	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 内容(支持HTML,但正文格式需要指定)
	 */
	private String message;

	/**
	 * 字符集
	 */
	private String charset = "utf-8";

	/**
	 * 超时时间
	 */
	private String timeOut;

	/**
	 * 正文格式(eg:text/html)
	 */
	private String contentType = "text/html;charset=UTF-8";
	
	/**
	 * 发送时间
	 */
	private Date sendDate;
	

}
