package org.anderneo.mybatis.sqlSession;


import java.util.List;

public interface SqlSession {

	<T> T selectOne(String statementId, Object parameter);

	<E> List<E> selectList(String statementId, Object parameter);

	void update(String statementId, Object parameter);

	void insert(String statementId, Object parameter);

	/**
	 * 获取mapper
	 * @param paramClass
	 * @param <T>
	 * @return
	 */
	<T> T getMapper(Class<T> paramClass);

	Configuration getConfiguration();
}
