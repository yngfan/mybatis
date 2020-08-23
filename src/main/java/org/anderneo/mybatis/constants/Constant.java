package org.anderneo.mybatis.constants;

/**
 * @author fan.yang
 * @date 2020/8/23 17:52
 */
public interface Constant {
	/** UTF-8编码 */
	String CHARSET_UTF8 = "UTF-8";

	String XML_ROOT_LABEL = "mapper";

	String XML_ELEMENT_ID = "id";

	String XML_SELECT_NAMESPACE = "namespace";

	String XML_SELECT_RESULTTYPE = "resultType";

	String DB_DRIVER_CONF = "db.driver";

	String DB_URL_CONF = "db.url";

	String DB_USERNAME_CONF = "db.username";

	String db_PASSWORD = "db.password";


	public enum SqlType {
		SELECT("select"),
		INSERT("insert"),
		UPDATE("update"),
		DEFAULT("default");

		private String value;

		private SqlType(String value)
		{
			this.value = value;
		}

		public String value()
		{
			return this.value;
		}
	}
}
