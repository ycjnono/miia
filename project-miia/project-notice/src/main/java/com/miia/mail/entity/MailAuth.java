/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.entity;

import lombok.Data;

/**
 * 邮箱认证实体
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Data
public class MailAuth {

	/**
	 * 认证邮箱地址
	 */
	private String address;

	/**
	 * 认证密码
	 */
	private String password;
}
