/**
 * 
 */
package com.miia.card.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.miia.base.entity.common.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 银行卡实体
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@NoArgsConstructor
@Table(name = "`bank_card`")
public class BankCard extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7054440258332146665L;

	/**
	 * 银行卡号
	 */
	@Column(name = "`account`")
	private String account;

	/**
	 * 银行卡类型
	 */
	@Column(name = "`cardType`")
	private int cardType;

	/**
	 * 到期时间
	 */
	@Column(name = "`expiryDate`")
	private String expiryDate;

}
