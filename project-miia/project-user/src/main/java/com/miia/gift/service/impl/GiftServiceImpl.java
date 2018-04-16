/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.miia.gift.factory.GiftPoolFactory;
import com.miia.gift.pool.Gift;
import com.miia.gift.pool.GiftPool;
import com.miia.gift.service.GiftService;
import com.miia.gift.service.ObserverPool;
import com.miia.gift.service.Observerable;

/**
 * 礼物服务接口
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Service
public class GiftServiceImpl implements Observerable, GiftService {

	/**
	 * 观察者集合
	 */
	public List<ObserverPool> list = new ArrayList<>();
	
	private GiftPool pool;

	private Gift gift;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.miia.gift.service.Observerable#registerObserver(com.miia.gift.service
	 * .Observer)
	 */
	@Override
	public void registerObserver(ObserverPool o) {
		if (list != null && list.size() > 0) {
			list.add(o);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.miia.gift.service.Observerable#removeObserver(com.miia.gift.service.
	 * Observer)
	 */
	@Override
	public void removeObserver(ObserverPool o) {
		if (list != null && list.size() > 0) {
			list.remove(o);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.miia.gift.service.Observerable#notifyObserver(com.miia.gift.service.
	 * Observer)
	 */
	@Override
	public void notifyObserver(ObserverPool o) {
		if (o != null) {
			o.update(gift);
		} else {
			for (ObserverPool observer : list) {
				observer.update(gift);
			}
		}
	}

	/**
	 * 
	 * @param gift
	 * @param o
	 */
	public void changePool(Gift gift, ObserverPool o) {
		this.gift = gift;
		System.out.println("更新资源池!");
		notifyObserver(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.gift.service.GiftService#draw()
	 */
	@Override
	public Gift draw() {
		if (pool == null) {
			pool  = GiftPoolFactory.getPool();
		}
		this.registerObserver(pool);
		Gift gift = this.random(pool);
		if (gift.getCode().equals("8888")) {
			gift.setWeight(0f);
			this.changePool(gift, pool);
		}
		return gift;
	}

	/**
	 * 根据资源池获取随机索引
	 * 
	 * @param list
	 * @return
	 */
	private Gift random(GiftPool pool) {
		List<Gift> list = pool.getPool();
		List<Float> sortRateList = new ArrayList<>();
		Float sunRate = 0f;
		for (Gift gift : list) {
			sunRate += gift.getWeight();
		}
		if (sunRate > 0f) {
			float rate = 0f; // 比例
			for (Gift gift : list) {
				rate += gift.getWeight();
				sortRateList.add(rate / sunRate);
			}
			float random = (float) Math.random();
			sortRateList.add(random);

			Collections.sort(sortRateList);

			// 返回该随机数在比例集合中的索引
			int index = sortRateList.indexOf(random);
			return list.get(index);
		}
		return null;
	}

}
