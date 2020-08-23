package org.anderneo.mybatis.executor.statement;

import org.anderneo.mybatis.mapping.MappedStatement;

/**
 * @author fan.yang
 * @date 2020/8/23 23:05
 */
public class SimpleStatementHandler {

	private MappedStatement mappedStatement;

	public SimpleStatementHandler(MappedStatement mappedStatement) {
		this.mappedStatement = mappedStatement;
	}
}
