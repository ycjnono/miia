/**
 * 
 */
package com.miia.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.miia.base.entity.common.BaseEntity;
import com.miia.card.entity.BankCard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户详情
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user_detail`")
public class UserDetail extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5564777709486150340L;

	/**
	 * 真实姓名
	 */
	@Column(name = "realName")
	private String realName;

	/**
	 * 身份证号
	 */
	@Column(name = "idNumber")
	private String idNumber;

	/**
	 * 年龄
	 */
	@Column(name = "age")
	private int age;

	/**
	 * 性别
	 */
	@Column(name = "gender")
	private String gender;

	/**
	 * 地址
	 */
	@Column(name = "address")
	private String address;

	/**
	 * 所在行业
	 */
	@Column(name = "industry")
	private String industry;

	/**
	 * 签名
	 */
	@Column(name = "autograph")
	private String autograph;

	/**
	 * 关联的卡包
	 */
	@OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_detail_id", nullable = false)
	private List<BankCard> cards;

}
