/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.pool;

import java.util.ArrayList;
import java.util.List;

import com.miia.gift.service.ObserverPool;

import lombok.Getter;
import lombok.Setter;

/**
 * 奖品池
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public class GiftPool implements ObserverPool {

	@Setter
	@Getter
	private List<Gift> pool = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.gift.service.Observer#update(com.miia.gift.Gift)
	 */
	@Override
	public void update(Gift gift) {
		if (pool != null && pool.size() > 0) {
			for (Gift source : pool) {
				if (source.getCode().equals(gift.getCode())) {
					source.setName(gift.getName());
					source.setWeight(gift.getWeight());
				}
			}
		}
	}

}
