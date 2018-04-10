package com.miia.vip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员类型
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@AllArgsConstructor
public enum MemberType {

	COMMON(999, "普通会员"), BRONZE(1, "铜牌会员"), SILVER(2, "银牌会员"), GOLD(3, "金牌会员"), SUPER(4, "超级会员");

	/**
	 * 会员类型编码
	 */
	private int typeCode;

	/**
	 * 会员类型名称
	 */
	private String typeName;

}
