package org.anderneo.mybatis.binding;

import org.anderneo.mybatis.sqlSession.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fan.yang
 * @date 2020/8/23 18:58
 */
public class MapperRegistry {

	public final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

	public void addMapper(Class type) {
		this.knownMappers.put(type, new MapperProxyFactory(type));
	}

	/**
	 * 获取代理工厂实例
	 * @param clz
	 * @param sqlSession
	 * @param <T>
	 * @return
	 */
	public <T> T getMapper(Class clz, SqlSession sqlSession) {
		MapperProxyFactory<?> mapperProxyFactory = this.knownMappers.get(clz);

		return mapperProxyFactory.newInstance(sqlSession);
	}
}
