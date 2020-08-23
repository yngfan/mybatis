package org.anderneo.mybatis.binding;

import org.anderneo.mybatis.constants.Constant;
import org.anderneo.mybatis.mapping.MappedStatement;
import org.anderneo.mybatis.sqlSession.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;

/**
 * @author fan.yang
 * @date 2020/8/23 21:45
 */
public class MapperProxy implements InvocationHandler {

	private SqlSession sqlSession;
	private Class mapperInterface;


	public MapperProxy(SqlSession sqlSession, Class mapperInterface) {
		this.sqlSession = sqlSession;
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (Objects.equals(Object.class, method.getDeclaringClass())) {
			return method.invoke(this, args);
		}

		return execute(method, args);
	}

	private Object execute(Method method, Object[] args) {
		String statementId = this.mapperInterface.getName() + "." + method.getName();
		MappedStatement mappedStatement = this.sqlSession.getConfiguration().getMappedStatement(statementId);

		Constant.SqlType sqlCommandType = mappedStatement.getSqlCommandType();

		Object result = null;
		switch (sqlCommandType) {
			case SELECT:
				Class<?> returnType = method.getReturnType();
				if (Collection.class.isAssignableFrom(returnType)) {

					result = sqlSession.selectList(statementId, args);
				} else {
					result = sqlSession.selectOne(statementId, args);
				}
				break;
			case UPDATE:
				sqlSession.update(statementId, args);
				break;
			case INSERT:

				break;
			default:
				break;
		}
		return result;
	}
}
