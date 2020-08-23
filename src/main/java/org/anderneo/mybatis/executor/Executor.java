package org.anderneo.mybatis.executor;

import org.anderneo.mybatis.mapping.MappedStatement;

import java.util.List;

/**
 * @author fan.yang
 * @date 2020/8/23 16:47
 */
public interface Executor {

	<E> List<E> doQuery(MappedStatement mappedStatement, Object parameter);

	void update(MappedStatement mappedStatement, Object parameter);
}
