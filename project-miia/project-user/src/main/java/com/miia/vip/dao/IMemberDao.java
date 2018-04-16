/**
 * all Copyright 2018 MIIA
 */
package com.miia.vip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miia.vip.entity.Member;

/**
 * 会员相关dao
 * @author yan.changjiang 
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Repository
public interface IMemberDao extends JpaRepository<Member, String> {

}
