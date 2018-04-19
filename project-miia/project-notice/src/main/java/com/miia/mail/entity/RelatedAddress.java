/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.miia.base.entity.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 与一封邮件相关系的收件人、抄送人、密送人
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`related_address`")
public class RelatedAddress extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1739681307475070044L;

	/**
	 * 邮件id
	 */
	@Column(name = "`mailId`")
	private String mailId;

	/**
	 * 发送关系->0:收件人,1:抄送人,2:密送人
	 */
	@Column(name = "`type`")
	private String type;

	/**
	 * 邮件地址
	 */
	@Column(name = "`address`")
	private String address;

}
