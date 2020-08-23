package org.anderneo.mybatis.executor;

import org.anderneo.mybatis.constants.Constant;
import org.anderneo.mybatis.executor.statement.SimpleStatementHandler;
import org.anderneo.mybatis.mapping.MappedStatement;
import org.anderneo.mybatis.sqlSession.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fan.yang
 * @date 2020/8/23 16:51
 */
public class SimpleExecutor implements Executor {
	// 数据库连接
	private static Connection connection;

	private Configuration configuration;

	static {
		initConnect();
	}

	/**
	 * 静态初始化数据库连接
	 */
	private static void initConnect() {

		String dbDriver = Configuration.getProperty(Constant.DB_DRIVER_CONF);
		String url = Configuration.getProperty(Constant.DB_URL_CONF);
		String username = Configuration.getProperty(Constant.DB_USERNAME_CONF);
		String password = Configuration.getProperty(Constant.db_PASSWORD);

		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		if (connection != null) {
			return connection;
		}
		throw new SQLException("数据库连接失败");
	}


	public SimpleExecutor(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public <E> List<E> doQuery(MappedStatement mappedStatement, Object parameter) {
		try {
			Connection connect = getConnect();

			SimpleStatementHandler statementHandler = new SimpleStatementHandler(mappedStatement);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(MappedStatement mappedStatement, Object parameter) {

	}
}
