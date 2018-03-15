package com.cloud.hybase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.base.builder.QueryBuilder;
import com.cloud.base.entity.Document;
import com.cloud.base.service.ISearchServie;

/**
 * 海贝检索服务
 * 
 * @author changjiang
 * @date 2018年3月15日 上午11:06:15
 * @since beijing
 */
@Service
public class HyBaseSearchService implements ISearchServie {

	@Override
	public boolean validSql(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Document> list(QueryBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

}
