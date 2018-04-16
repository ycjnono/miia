/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miia.cache.IRedisService;
import com.miia.gift.pool.Gift;
import com.miia.gift.service.GiftService;

/**
 * 礼物接口
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@RestController
@RequestMapping("/gift")
public class GiftController {

	@Autowired
	private GiftService giftService;
	
	@Autowired
	private IRedisService redisService;

	/**
	 * 抽奖
	 * 
	 * @return
	 */
	@GetMapping(value = "/draw")
	public Object draw(String userId) {
		List<Gift> list = new ArrayList<>();
		if (!redisService.hasKey(userId)) {
			for (int i = 0; i < 1000; i++) {
				Gift gift = this.giftService.draw();
				System.out.println(userId + "-->第" + (i + 1) + "次抽奖:" + gift.toString());
				list.add(gift);
			}
			redisService.set(userId, list, 50);
			return list;
		}else {
			return redisService.get(userId);
		}
	}

}
