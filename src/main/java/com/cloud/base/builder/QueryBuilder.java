package com.cloud.base.builder;

import java.util.Date;

/**
 * 查询条件构造器
 * 
 * @author changjiang
 * @date 2018年3月15日 下午2:40:31
 * @since beijing
 */
public abstract class QueryBuilder implements Cloneable {

	/**
	 * 库名
	 */
	protected String database;

	/**
	 * 查询语句
	 */
	protected String sql;

	/**
	 * 排序字段
	 */
	protected String orderBy;

	/**
	 * 开始时间
	 */
	protected Date begin;

	/**
	 * 结束时间
	 */
	protected Date end;

	/**
	 * 分页号
	 */
	protected int pageNo;

	/**
	 * 分页长
	 */
	protected int pageSize;

	/**
	 * 无分页最大检索条数
	 */
	protected int maxSize = 9999;

	/**
	 * 转换为完整的查询sql语句
	 * 
	 * @return
	 */
	public abstract String asSql();

}
