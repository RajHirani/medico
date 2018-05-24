package com.hd.medico.core.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Raj Hirani <hiraniraj45@gmail.com>
 *
 */
@Component
public class ConnectionFactory{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.HD.core.db.ConnectionFactory#getDbConnection()
	 */
	public Connection getDBConnection() {
		Connection connection = null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return connection;
		}
	}
}
