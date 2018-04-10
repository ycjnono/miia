package com.miia.vip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员开通方式
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@AllArgsConstructor
public enum MemberOpenType {

	WECHAT(1, "微信支付"), ALIPAY(2, "支付宝支付"), BANK(3, "银联支付"), QQ(4, "QQ支付"), SMS(5, "短信支付");

	/**
	 * 开通方式编码
	 */
	private int openTypeCode;

	/**
	 * 开通方式名称
	 */
	private String openTypeName;

}
