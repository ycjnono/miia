package com.cloud.base.entity;

import java.util.Date;

import lombok.Data;

/**
 * 全文检索文章对象基类
 * 
 * @author changjiang
 * @date 2018年3月15日 下午8:58:15
 * @since beijing
 */
@Data
public abstract class Document {

	/**
	 * 唯一id
	 */
	protected String id;

	/**
	 * 标题
	 */
	protected String title;

	/**
	 * 正文
	 */
	protected String content;

	/**
	 * 入库时间
	 */
	protected Date loadTime;

	/**
	 * 发布时间
	 */
	protected Date releaseTime;

	/**
	 * 排重标记
	 */
	protected String simflg;

	/**
	 * 正文md5值
	 */
	protected String md5;

	/**
	 * 主题词MD5值,作为文章排重的基础指标
	 */
	protected String md5flg;

}
