/**
 * all Copyright 2018 MIIA
 */
package com.miia.gift.service;

/**
 * 被观察者
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface Observerable {

	/**
	 * 注册观察者
	 * 
	 * @param o
	 */
	public void registerObserver(ObserverPool o);

	/**
	 * 注销观察者
	 * 
	 * @param o
	 */
	public void removeObserver(ObserverPool o);

	/**
	 * 通知观察者
	 * 
	 * @param o
	 */
	public void notifyObserver(ObserverPool o);

}
