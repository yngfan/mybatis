package org.anderneo.mybatis.binding;

import org.anderneo.mybatis.sqlSession.SqlSession;

/**
 * @author fan.yang
 * @date 2020/8/23 19:01
 */
public class MapperProxyFactory<T> {

	private final Class<T> mapperInterface;

	public MapperProxyFactory(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	public <T> T newInstance(SqlSession sqlSession) {

		return null;
	}
}
