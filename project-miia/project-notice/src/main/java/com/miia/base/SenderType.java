/**
 * all Copyright 2018 MIIA
 */
package com.miia.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通知方式枚举类
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@AllArgsConstructor
public enum SenderType {
	
	MAIL("1001","com.miia.mail.MailSender"),
	WECHAT("1002","com.miia.mail.MailSender"),
	COMMON("1003","com.miia.mail.MailSender");
	
	private String code;
	
	private String source;

}
