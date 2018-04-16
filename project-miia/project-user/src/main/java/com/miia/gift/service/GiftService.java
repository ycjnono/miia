/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.service;

import com.miia.gift.pool.Gift;

/**
 * 礼物相关服务接口
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface GiftService {

	/**
	 * 抽奖
	 * 
	 * @return
	 */
	public Gift draw();
}
