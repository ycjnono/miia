package com.cloud.base.builder.condition;

import lombok.Data;

/**
 * 排序实体类
 * 
 * @author changjiang
 * @date 2018年3月15日 下午8:18:09
 * @since beijing
 */
@Data
public class Sort {

	/**
	 * 比较符
	 * 
	 * @author changjiang
	 * @date 2018年3月15日 下午8:53:13
	 * @since beijing
	 */
	public enum Oper {

		DESC, ESC
	}

	/**
	 * 排序字段
	 */
	private String field;

	/**
	 * 比较符
	 */
	private Oper oper;

}
