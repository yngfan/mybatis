package org.anderneo.mybatis.executor.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface StatementHandler {

	PreparedStatement prepare(Connection connection);
}
