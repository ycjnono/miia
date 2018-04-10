/**
 * all Copyright 2018 MIIA
 */
package com.miia.card.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 银行卡类型
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@AllArgsConstructor
public enum CardType {

	Credit(1, "信用卡"), Savings(2, "储蓄卡");

	/**
	 * 银行卡类型代码
	 */
	private int typeCode;

	/**
	 * 银行卡类型名称
	 */
	private String typeName;

}
