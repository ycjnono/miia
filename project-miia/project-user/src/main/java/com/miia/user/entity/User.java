package com.miia.user.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.miia.base.entity.common.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户实体
 * 
 * @author ycj
 * @since miia group for beijing @ 2018
 * @version 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "`user`")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4682392286937450186L;

	/**
	 * 用户名
	 */
	@Column(name = "`username`", updatable = false)
	private String username;

	/**
	 * 手机号
	 */
	@Column(name = "`phone`", updatable = false)
	private String phone;

	/**
	 * 邮箱
	 */
	@Column(name = "`email`", updatable = false)
	private String email;

	/**
	 * 密码
	 */
	@Column(name = "`password`")
	private String password;

	/**
	 * 加密值
	 */
	@Column(name = "`salt`")
	private String salt;

	/**
	 * 是否进行实名认证
	 */
	@Column(name = "`validity`")
	private boolean validity;
	
	/**
	 * 用户详情
	 */
	@Transient
	private UserDetail detail;

}
