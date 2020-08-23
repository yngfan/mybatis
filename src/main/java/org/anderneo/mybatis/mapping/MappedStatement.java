package org.anderneo.mybatis.mapping;


import org.anderneo.mybatis.constants.Constant;

/**
 * @author fan.yang
 * @date 2020/8/23 17:10
 */
public final class MappedStatement {

	// xml文件的namespace
	private String namespace;
	// sql的id属性
	private String statementId;
	// sql语句，对应源码的sqlSource
	private String sql;
	// 返回类型
	private String resultType;
	// 对应select/update/insert
	private Constant.SqlType sqlCommandType;


	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getStatementId() {
		return statementId;
	}

	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public Constant.SqlType getSqlCommandType() {
		return sqlCommandType;
	}

	public void setSqlCommandType(Constant.SqlType sqlCommandType) {
		this.sqlCommandType = sqlCommandType;
	}
}
