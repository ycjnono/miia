package com.cloud.base.builder.condition;

import lombok.Data;

/**
 * 查询条件
 * 
 * @author changjiang
 * @date 2018年3月15日 下午4:19:25
 * @since beijing
 */
@Data
public class QueryCondition {
	
	/**
	 * 字段
	 */
	private String field;
	
	/**
	 * 值
	 */
	private String[] value;
	
	/**
	 * 运算符
	 */
	private Operator operator;
}
