package com.miia.search.builder;

import java.util.Date;

/**
 * 检索条件构造器
 * 
 * @author ycj
 * @since miia group for beijing @ 2018
 * @version 1.0.0
 */
public class QueryBuilder implements Cloneable {
	
	private String[] databases;
	
	private Date startTime;
	
	private Date endTime;
	
	private String orderBy;
	
	private int pageNo;
	
	private int pageSize;

}
