package cn.common.log;

import java.io.Serializable;

public class SqlLog implements Serializable {

	private static final long serialVersionUID = 1283213409679360735L;

	private String sql;

	private String parameter;

	public SqlLog(String sql, String parameter) {
		super();
		this.sql = sql;
		this.parameter = parameter;
	}

	public SqlLog() {
		super();
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
