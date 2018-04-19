/**
 * all Copyright 2018 MIIA
 */
package com.miia.mail.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miia.mail.entity.Mail;

/**
 * 邮件数据交互层
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Repository
public interface IMailDao extends JpaRepository<Mail, String> {

}
