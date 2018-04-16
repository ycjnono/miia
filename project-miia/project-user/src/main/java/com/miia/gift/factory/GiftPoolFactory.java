/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.factory;

import java.util.ArrayList;
import java.util.List;

import com.miia.gift.pool.Gift;
import com.miia.gift.pool.GiftPool;

/**
 * 奖池工厂类
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public class GiftPoolFactory implements Cloneable {

	private static GiftPool pool;

	/**
	 * 获取奖池
	 * 
	 * @return
	 */
	public static GiftPool getPool() {
		if (pool != null) {
			pool.setPool(defaultSource());
		}else {
			pool = new GiftPool();
			pool.setPool(defaultSource());
		}
		return pool;
	}

	/**
	 * 默认奖池资源
	 * 
	 * @return
	 */
	@SuppressWarnings("serial")
	private static List<Gift> defaultSource() {
		List<Gift> list = new ArrayList<Gift>() {
			{
				add(new Gift("1001", "小鲤鱼", 0.1f));
				add(new Gift("1002", "小草鱼", 0.1f));
				add(new Gift("1003", "小黑鱼", 0.1f));
				add(new Gift("1004", "小章鱼", 0.1f));
				add(new Gift("1005", "小鳗鱼", 0.1f));

				add(new Gift("2001", "紫玉", 0.03f));
				add(new Gift("2002", "青玉", 0.03f));
				add(new Gift("2003", "红玉", 0.03f));

				add(new Gift("3001", "鲨鱼", 0.1f));
				add(new Gift("3002", "海蛇", 0.1f));
				add(new Gift("3003", "海怪", 0.1f));

				add(new Gift("8888", "宝箱", 0.01f));
				add(new Gift("9999", "空", 0.1f));
			}
		};
		return list;
	}
}
