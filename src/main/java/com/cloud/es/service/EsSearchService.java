package com.cloud.es.service;

import org.springframework.stereotype.Service;

import com.cloud.base.service.ISearchServie;

/**
 * es检索服务
 * 
 * @author changjiang
 * @date 2018年3月15日 上午11:05:48
 * @since beijing
 */
@Service
public class EsSearchService implements ISearchServie {

	@Override
	public boolean validSql(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

}
