package com.miia.search.builder;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * search builder
 * @author yan.changjiang 
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@Setter
public class QueryBuilder implements Cloneable {
	
	/**
	 * database name
	 */
	private String[] databases;
	
	/**
	 * 开始时间
	 */
	private Date startTime;
	
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	/**
	 * 排序字段
	 */
	private String orderBy;
	
	/**
	 * 页码
	 */
	private int pageNo;
	
	/**
	 * 每页展示条数
	 */
	private int pageSize;

}
