/**
 * 
 */
package com.miia.card.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miia.card.entity.BankCard;

/**
 * 卡包dao
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface IBankCardDao extends JpaRepository<String, BankCard> {

}
