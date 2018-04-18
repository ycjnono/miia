/**
 * all Copyright 2018 MIIA
 */
package com.miia.base;

import java.util.Properties;

import com.miia.base.exception.BaseException;

/**
 * 通知发送器基类
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public abstract class AbstractSender {

	

	/**
	 * 配置
	 */
	protected NoticeConfig config;

	protected Properties properties;

	/**
	 * 初始化
	 * 
	 * @param config
	 */
	public void init(NoticeConfig config) {
		this.config = config;
	}

	/**
	 * 发送
	 * 
	 * @return
	 */
	public abstract boolean send() throws BaseException;

}
