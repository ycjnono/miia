package com.miia.document.entity;

import java.io.Serializable;
import java.util.Date;

import com.miia.annotation.Field;

import lombok.Data;

/**
 * 通用文章实体
 * 
 * @author ycj
 * @since miia group for beijing @ 2018
 * @version 1.0.0
 */
@Data
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4707793752163025801L;

	/**
	 * 唯一标识
	 */
	@Field(name = "ID")
	private String id;

	/**
	 * 标题
	 */
	@Field(name = "TITLE", isHighLight = true)
	private String title;

	/**
	 * 摘要
	 */
	@Field(name = "ABSTRACTS", isHighLight = true)
	private String abstracts;

	/**
	 * 正文
	 */
	@Field(name = "CONTENT", isHighLight = true)
	private String content;

	/**
	 * 发布时间
	 */
	@Field(name = "URLTIME")
	private Date urlTime;

	/**
	 * 入库时间
	 */
	@Field(name = "LOADTIME")
	private Date loadTime;

	/**
	 * 原文链接
	 */
	@Field(name = "URLLINKED")
	private String urlLinked;

	/**
	 * 正文解析-关键词
	 */
	private String keywords;

	/**
	 * 正文解析-人名
	 */
	private String people;

	/**
	 * 正文解析-地域
	 */
	private String location;

	/**
	 * 正文解析-机构,组织
	 */
	private String agency;

}
