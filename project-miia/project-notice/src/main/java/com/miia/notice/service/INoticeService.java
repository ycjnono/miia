/**
 * all Copyright 2018 MIIA
 */
package com.miia.notice.service;

import com.miia.exception.SearchException;
import com.miia.exception.SendException;

/**
 * 集成通知服务接口
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public interface INoticeService {
	
	public Object sendMessage() throws SendException;
	
	public Object listMailForder(int pageNo, int pageSize) throws SearchException;

}
