/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.miia.base.entity.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * mail 实体
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`mail`")
@Entity
public class Mail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9069702825678919871L;

	/**
	 * 邮件文件夹
	 */
	@Column(name = "`folder`")
	private String folder;

	/**
	 * 邮件主题
	 */
	@Column(name = "`subject`")
	private String subject;

	/**
	 * 发送人
	 */
	@Column(name = "`fromAddress`")
	private String fromAddress;
	
	/**
	 * 正文
	 */
	@Column(name = "`content`")
	private String content;
	
}
