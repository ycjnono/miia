package com.miia.vip.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.miia.base.entity.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 会员实体
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Entity
@Table(name = "`member`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3906623262945775600L;

	/**
	 * 等级
	 */
	@Column(name = "`level`")
	private int level = 0;

	/**
	 * 经验值
	 */
	@Column(name = "`exp`")
	private int exp;

	/**
	 * 到期时间
	 */
	@Column(name = "`timeOut`")
	private Date timeOut;

	/**
	 * 会员类型
	 */
	@Column(name = "`type`")
	private int type = 1;
	
	/**
	 * 会员类型,等比与会员级别
	 */
	@Transient
	private String typeName;

	/**
	 * 是否开启,默认关闭
	 */
	@Column(name = "`open`")
	private boolean open = false;

	/**
	 * 开通方式
	 */
	@Column(name = "`openType`")
	private int openType;

	/**
	 * 开通方式名称
	 */
	@Transient
	private String openTypeName;

	/**
	 * 是否删除,默认false
	 */
	@Column(name = "`isDelete`")
	private boolean isDelete = false;

	public void setOpenTypeName(String openTypeName) {
		for(MemberOpenType eumn : MemberOpenType.values() ){
			if (openType == eumn.getOpenTypeCode()) {
				this.openTypeName = eumn.getOpenTypeName();
			}
		}
		this.openTypeName = openTypeName;
	}

	
}
