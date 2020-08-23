package org.anderneo.mybatis.sqlSession;

import org.anderneo.mybatis.binding.MapperRegistry;
import org.anderneo.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 核心配置类
 * @author fan.yang
 * @date 2020/8/23 16:44
 */
public class Configuration {
	// 配置项
	public static Properties PROPS = new Properties();

	protected  final MapperRegistry mapperRegistry = new MapperRegistry();
	protected final Map<String, MappedStatement> mappedStatementMap = new HashMap<>();


	public void addMapper(Class clz) {
		this.mapperRegistry.addMapper(clz);
	}

	public <T> T getMapper(Class clz, SqlSession sqlSession) {
		return this.mapperRegistry.getMapper(clz, sqlSession);
	}

	public void addMappedStatement(String statementId, MappedStatement mappedStatement) {
		this.mappedStatementMap.put(statementId, mappedStatement);
	}
	/**
	 * 获取MappedStatement
	 * @param statementId
	 * @return
	 */
	public MappedStatement getMappedStatement(String statementId) {
		return this.mappedStatementMap.get(statementId);
	}

	public static String getProperty(String key) {
		return getProperty(key, "");
	}

	public static String getProperty(String key, String defaultValue) {
		return PROPS.contains(key) ? PROPS.getProperty(key) : defaultValue;
	}
}
