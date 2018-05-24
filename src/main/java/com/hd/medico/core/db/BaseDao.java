package com.hd.medico.core.db;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Raj Hirani
 *
 */
public class BaseDao {

	protected SqlUtil sqlUtil;

	/**
	 * @return the sqlUtil
	 */
	public SqlUtil getSqlUtil() {
		return sqlUtil;
	}

	/**
	 * @param sqlUtil the sqlUtil to set
	 */
	@Autowired
	public void setSqlUtil(SqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	
}
