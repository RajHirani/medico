package com.hd.medico.core.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;




/**
 * This class provides various functions to execute CRUD Operations on database.
 * 
 * @author Raj Hirani
 */
public abstract class BaseSqlUtil {

	protected ConnectionFactory connectionFactory;
	
	Logger logger = Logger.getLogger(BaseSqlUtil.class);

	/**
	 * All static methods are supplied, so no instance of this class is to be
	 * created.
	 * 
	 */
	public BaseSqlUtil() {

	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	@Autowired
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param <T>
	 *            The type of bean class that the function returns
	 * @param query
	 *            The SQL query to be executed
	 * @param beanClass
	 *            The bean class which is to be returned.
	 * @param params
	 *            The replacement parameters which are to be passed to query
	 * @return A first row from result. The bean class
	 * @throws Exception
	 */
	public <T> T getQueryBean(String query, Class<T> beanClass,
			Object... params) throws Exception {

		Connection connection = null;
		T result = null;
	
		try {
			connection = connectionFactory.getDBConnection();
			result = getQueryBean(connection, query, beanClass, params);
		} finally {
			DbUtils.closeQuietly(connection);
		}

		return result;
	}

	/**
	 * Executes a SQL Query with or without replacement parameters. This method
	 * expects SQL Connection object as inputs
	 * 
	 * @param connection
	 *            Connection object got from Datasource lookup
	 * @param <T>
	 *            The type of bean class that the function returns
	 * @param query
	 *            The SQL query to be executed
	 * @param beanClass
	 *            The bean class which is to be returned.
	 * @param params
	 *            The replacement parameters which are to be passed to query
	 * @return A first row from result. The bean class
	 * @throws Exception
	 */
	public <T> T getQueryBean(Connection connection, String query,
			Class<T> beanClass, Object... params) throws Exception {


		ResultSetHandler<T> resultSetHandler = new BeanHandler<T>(beanClass);
		QueryRunner queryRunner = new QueryRunner(true);
		T result = null;

		try {
			result = queryRunner.query(connection, query, resultSetHandler,
					params);
		} catch (SQLException e) {
			throw new Exception(e);
		} catch (Exception exception) {
			throw new Exception(exception);
		}
		return result;
	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param <T>
	 *            The type of bean class that the function returns
	 * @param query
	 *            The SQL query to be executed
	 * @param beanClass
	 *            The bean class which is to be returned.
	 * @param params
	 *            The replacement parameters which are to be passed to query
	 * @return A List containing bean class
	 * @throws Exception
	 */
	public <T> List<T> getQueryBeans(String query, Class<T> beanClass,
			Object... params) throws Exception {


		Connection connection = null;
		List<T> result = null;

		try {
			connection = connectionFactory.getDBConnection();
			result = getQueryBeans(connection, query, beanClass, params);
		} finally {
			DbUtils.closeQuietly(connection);
		}

		return result;

	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param connection
	 *            Connection object got from Datasource lookup
	 * @param <T>
	 *            The type of bean class that the function returns
	 * @param query
	 *            The SQL query to be executed
	 * @param beanClass
	 *            The bean class which is to be returned.
	 * @param params
	 *            The replacement parameters which are to be passed to query
	 * @return A List containing bean class
	 * @throws Exception
	 */
	public <T> List<T> getQueryBeans(Connection connection, String query,
			Class<T> beanClass, Object... params) throws Exception {

		ResultSetHandler<List<T>> resultSetHandler = new BeanListHandler<T>(
				beanClass);
		QueryRunner queryRunner = new QueryRunner(true);
		List<T> result = null;

		try {
			result = queryRunner.query(connection, query, resultSetHandler,
					params);
		} catch (SQLException e) {
//
//			String errorMessage = ErrorMessageConstants.QUERY_EXECUTION_FAILURE
//					+ "\n\n" + logger.setParameter(query, params)
//					+ "\n\n" + e.getMessage();
//
//			throw new DaoException(errorMessage);
			throw new Exception(e);

		} catch (Exception exception) {
//			logger.error(exception.getMessage(), exception);
//
//			String errorMessage = ErrorMessageConstants.QUERY_EXECUTION_FAILURE
//					+ "\n\n" + logger.setParameter(query, params)
//					+ "\n\n" + exception.getMessage();
//
//			throw new DaoException(errorMessage);
			throw new Exception(exception);
		}
		return result;

	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param query
	 *            The SQL query to be executed
	 * @param params
	 *            The replacement parameters which are to be passed to query
	 * @return First row from query. A Map containing key as columnNames and
	 *         value as database value.
	 * @throws Exception
	 */
	public Map<String, Object> getQueryMap(String query, Object... params)
			throws Exception {

		logger.debug("Inside getQueryMap ..SQL Query is :" + query);

		Connection connection = null;
		Map<String, Object> result = null;

		try {
			connection = connectionFactory.getDBConnection();
			result = getQueryMap(connection, query, params);
		} finally {
			DbUtils.closeQuietly(connection);
		}

		return result;
	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param connection
	 *            Connection object got from Datasource lookup
	 * @param query
	 *            The SQL query to be executed
	 * @param params
	 *            The replacement parameters which are to be passed to query
	 * @return First row from query. A Map containing key as columnNames and
	 *         value as database value.
	 * @throws Exception
	 */
	public Map<String, Object> getQueryMap(Connection connection, String query,
			Object... params) throws Exception {

		logger.debug(
				"Inside getQueryMap with Connection..SQL Query is :" + query);

		ResultSetHandler<Map<String, Object>> handler = new MapHandler();
		QueryRunner queryRunner = new QueryRunner(true);
		Map<String, Object> result = null;

		try {
			result = queryRunner.query(connection, query, handler, params);
		} catch (SQLException ex) {
			logger.error(ex.getMessage(), ex);
			throw new Exception(ex);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new Exception(ex);
		}
		return result;
	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param query
	 *            The SQL query to be executed
	 * @param params
	 *            The SQL query to be executed
	 * @return A List containing a Map which contains key as columnNames and
	 *         value as database value.
	 * @throws Exception
	 */
	public List<Map<String, Object>> getQueryMaps(String query,
			Object... params) throws Exception {

		logger.debug("Inside getQueryMaps ..SQL Query is :" + query);

		Connection connection = null;
		List<Map<String, Object>> result = null;

		try {
			connection = connectionFactory.getDBConnection();
			result = getQueryMaps(connection, query, params);
		} finally {
			DbUtils.closeQuietly(connection);
		}

		return result;
	}

	/**
	 * Executes a SQL Query with or without replacement parameters.
	 * 
	 * @param connection
	 *            Connection object got from Datasource lookup
	 * @param query
	 *            The SQL query to be executed
	 * @param params
	 *            The SQL query to be executed
	 * @return A List containing a Map which contains key as columnNames and
	 *         value as database value.
	 * @throws Exception
	 */
	public List<Map<String, Object>> getQueryMaps(Connection connection,
			String query, Object... params) throws Exception {

		logger.debug(
				"Inside getQueryMaps with Connection object..SQL Query is :"
						+ query);

		ResultSetHandler<List<Map<String, Object>>> handler = new MapListHandler();
		QueryRunner queryRunner = new QueryRunner();
		List<Map<String, Object>> result = null;

		try {

			result = queryRunner.query(connection, query, handler, params);

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);


			throw new Exception(e);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			throw new Exception(exception);
		}
		return result;
	}

	/**
	 * Execute an SQL INSERT, UPDATE, or DELETE query with placement parameters.
	 * 
	 * @param query
	 *            The query to be executed.
	 * @param params
	 *            The replacement parameters which are passed to the query
	 * @return Number of rows affected by the query.
	 * @throws Exception
	 */
	public long dmlExecutor(String query, Object... params)
			throws Exception {

		logger.debug("Inside dmlExecutor ..SQL Query is :" + query);

		Connection conn = null;

		long result = 0;

		try {
			conn = connectionFactory.getDBConnection();
			result = dmlExecutor(conn, query, params);
			DbUtils.commitAndCloseQuietly(conn);
		} finally {
			DbUtils.closeQuietly(conn);
		}

		return result;
	}

	/**
	 * Execute an SQL INSERT, UPDATE, or DELETE query with placement parameters.
	 * 
	 * @param conn
	 *            Connection object got from Datasource lookup
	 * @param query
	 *            The query to be executed.
	 * @param params
	 *            The replacement parameters which are passed to the query
	 * @return Number of rows affected by the query.
	 * @throws Exception
	 */
	public long dmlExecutor(Connection conn, String query, Object... params)
			throws Exception {

		logger.debug(
				"Inside dmlExecutor with Connection object..SQL Query is :"
						+ query);

		QueryRunner queryRunner = new QueryRunner(true);

		long result = 0;

		try {

			result = queryRunner.update(conn, query, params);

		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			logger.error(e.getMessage(), e);

			throw new Exception(e);

		} catch (Exception exception) {
			DbUtils.rollbackAndCloseQuietly(conn);
			logger.error(exception.getMessage(), exception);

			throw new Exception(exception);
		}
		return result;
	}

	/**
	 * Execute an SQL INSERT, UPDATE, or DELETE query with placement parameters.
	 * 
	 * @param query
	 *            The query to be executed.
	 * @param params
	 *            The replacement parameters which are passed to the query
	 * @param sequenceField
	 *            Name of the Oracle sequence field
	 * @return Number of rows affected by the query. Incase of insert query ,
	 *         Return sequence id of Oracle which is inserted in the Database.
	 * @throws Exception
	 */

	public long dmlExecutor(String query, Object[] params, String sequenceField)
			throws Exception {

		logger.debug(
				"Inside dmlExecutor in sequenceField method  ..SQL Query is :"
						+ query);

		Connection conn = null;
		long result = 0;

		try {
			conn = connectionFactory.getDBConnection();
			result = dmlExecutor(conn, query, params, sequenceField);
			DbUtils.commitAndCloseQuietly(conn);

		} finally {
			DbUtils.closeQuietly(conn);
		}

		return result;
	}

	/**
	 * Close a <code>Connection</code>
	 * 
	 * @param connection
	 *            Connection to close.
	 */
	public void closeQuietly(Connection connection) {

		DbUtils.rollbackAndCloseQuietly(connection);
		logger.debug("Connection is closed");

	}

	/**
	 * Performs a rollback on the <code>Connection</code> then closes it, avoid
	 * closing if null and hide any SQLExceptions that occur.
	 * 
	 * @param connection
	 *            Connection to rollback. A null value is legal.
	 */
	public void rollbackAndCloseQuietly(Connection connection) {
		DbUtils.rollbackAndCloseQuietly(connection);
		logger.debug("Connection is closed");
	}

	/**
	 * Commits a <code>Connection</code> then closes it, avoid closing if null
	 * and hide any SQLExceptions that occur.
	 * 
	 * @param connection
	 *            Connection to close.
	 */

	public void commitAndCloseQuietly(Connection connection) {
		DbUtils.commitAndCloseQuietly(connection);
		logger.debug("Connection is closed");
	}

	/**
	 * Close a statement quietly.
	 * 
	 * @param statement
	 */
	public void closeStatementQuietly(Statement statement) {
		DbUtils.closeQuietly(statement);
	}

	public void closeResultSetQuietly(ResultSet resultSet) {
		DbUtils.closeQuietly(resultSet);
		try {
			DbUtils.closeQuietly(resultSet.getStatement());
		} catch (SQLException e) {
			// suppressing error.
		}

	}

	/**
	 * This method is used to get the result set that is generated using query.
	 * 
	 * @param connection
	 *            - pass the connection object to obtain the result set.
	 * @param query
	 *            - query to get the result set
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet getResultSet(Connection connection, String query,
			Object[] params) throws Exception {

		QueryRunner queryRunner = new QueryRunner(true);
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.prepareStatement(query);
			queryRunner.fillStatement(stmt, params);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
//
//			String errorMessage = ErrorMessageConstants.QUERY_EXECUTION_FAILURE
//					+ "\n\n" + logger.setParameter(query, params)
//					+ "\n\n" + e.getMessage();
//
//			throw new DaoException(errorMessage);
			throw new Exception(e);
		} catch (Exception exception) {
//			logger.error(exception.getMessage(), exception);
//
//			String errorMessage = ErrorMessageConstants.QUERY_EXECUTION_FAILURE
//					+ "\n\n" + logger.setParameter(query, params)
//					+ "\n\n" + exception.getMessage();
//
//			throw new DaoException(errorMessage);
			throw new Exception(exception);
		}
		return rs;
	}
}
