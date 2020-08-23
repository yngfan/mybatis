package org.anderneo.mybatis.sqlSession.defaults;

import org.anderneo.mybatis.executor.Executor;
import org.anderneo.mybatis.executor.SimpleExecutor;
import org.anderneo.mybatis.mapping.MappedStatement;
import org.anderneo.mybatis.sqlSession.Configuration;
import org.anderneo.mybatis.sqlSession.SqlSession;
import org.anderneo.mybatis.utils.CommonUtis;

import java.util.List;

/**
 * 默认sql会话实现类
 * @author fan.yang
 * @date 2020/8/23 16:40
 */
public class DefaultSqlSession implements SqlSession {

	private Configuration configuration;

	private Executor executor;

	public DefaultSqlSession(Configuration configuration) {
		this.configuration = configuration;
		this.executor = new SimpleExecutor(configuration);
	}

	@Override
	public <T> T selectOne(String statementId, Object parameter) {
		List<T> results = this.selectList(statementId, parameter);

		return CommonUtis.isNotEmpty(results) ? results.get(0) : null;
	}

	@Override
	public <E> List<E> selectList(String statementId, Object parameter) {
		MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
		return this.executor.doQuery(mappedStatement, parameter);
	}

	@Override
	public void update(String statementId, Object parameter) {

	}

	@Override
	public void insert(String statementId, Object parameter) {

	}

	@Override
	public <T> T getMapper(Class<T> paramClass) {
		return null;
	}

	@Override
	public Configuration getConfiguration() {
		return this.configuration;
	}
}
