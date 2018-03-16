package com.cloud.base.builder;

import java.util.Date;
import java.util.List;

import com.cloud.base.builder.condition.QueryCondition;
import com.cloud.base.builder.condition.Sort;

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
	 * 排序
	 */
	protected Sort sort;

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
	 * 与条件集合
	 */
	protected List<QueryCondition> conditions;

	/**
	 * 或条件集合
	 */
	protected List<QueryCondition> childrenConditions;

	/**
	 * 克隆
	 */
	public abstract QueryCondition clone();

	/**
	 * 转换为完整的原生sql语句
	 * 
	 * @return
	 */
	public abstract String asSql();

	/**
	 * 添加与条件
	 * 
	 * @param condition
	 */
	public abstract void addCondition(QueryCondition condition);

	/**
	 * 添加或条件
	 * 
	 * @param condition
	 */
	public abstract void addChidrenCondition(QueryCondition condition);

}
