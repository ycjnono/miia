/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.pool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 礼物实体
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift {

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 礼物名称
	 */
	private String name;

	/**
	 * 权重
	 */
	private float weight;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gift [code=" + code + ", name=" + name + ", weight=" + weight + "]";
	}

}
