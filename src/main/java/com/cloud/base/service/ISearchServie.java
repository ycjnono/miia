package com.cloud.base.service;

import java.util.List;

import com.cloud.base.builder.QueryBuilder;
import com.cloud.base.entity.Document;

/**
 * 全文检索数据库检索服务接口
 * 
 * @author changjiang
 * @date 2018年3月15日 上午10:55:55
 * @since beijing
 */
public interface ISearchServie {

	/**
	 * 校验检索语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean validSql(String sql);

	/**
	 * 无分页列表检索
	 * 
	 * @param builder
	 * @return
	 */
	public List<Document> list(QueryBuilder builder);
}
