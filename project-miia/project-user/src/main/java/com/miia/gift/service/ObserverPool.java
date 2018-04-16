/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.service;

import com.miia.gift.pool.Gift;

/**
 * 奖池观察者
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface ObserverPool {

	/**
	 * 修改中奖概率
	 * 
	 * @param gift
	 */
	public void update(Gift gift);

}
