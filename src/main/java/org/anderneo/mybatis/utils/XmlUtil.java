package org.anderneo.mybatis.utils;

import org.anderneo.mybatis.constants.Constant;
import org.anderneo.mybatis.mapping.MappedStatement;
import org.anderneo.mybatis.sqlSession.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author fan.yang
 * @date 2020/8/23 18:19
 */
public class XmlUtil {

	public static void readMapperXml(File fileName, Configuration configuration) {
		// 创建一个读取器
		SAXReader reader = new SAXReader();
		reader.setEncoding(Constant.CHARSET_UTF8);
		// 读取文件内容
		try {
			List<MappedStatement> statementsList = new ArrayList<>();

			Document document = reader.read(fileName);
			// 读取xml中的根元素
			Element rootElement = document.getRootElement();
			if (!Objects.equals(rootElement.getName(), Constant.XML_ROOT_LABEL)) {
				System.err.println("xml文件的根元素不是mapper");
				return;
			}

			String namespace = rootElement.attributeValue(Constant.XML_SELECT_NAMESPACE);

			Iterator iterator = rootElement.elementIterator();
			while (iterator.hasNext()) {
				Element element = (Element) iterator.next();
				String elementName = element.getName();

				MappedStatement mappedStatement = new MappedStatement();

				for (Constant.SqlType sqlType: Constant.SqlType.values()) {
					switch (sqlType) {
						case SELECT:
							String resultType = element.attributeValue(Constant.XML_SELECT_RESULTTYPE);
							mappedStatement.setSqlCommandType(sqlType);
							mappedStatement.setResultType(resultType);
							break;
						case UPDATE:
							break;
						case INSERT:
							break;
						default:
							System.err.println("标签错误" + sqlType.toString());
							break;
					}
				}

				String xmlElementId = element.attributeValue(Constant.XML_ELEMENT_ID);
				// 设置statementId
				String statementId = namespace + "." + xmlElementId;

				mappedStatement.setStatementId(statementId);
				mappedStatement.setNamespace(namespace);
				mappedStatement.setSql(element.getStringValue());

				statementsList.add(mappedStatement);

				configuration.addMappedStatement(statementId, mappedStatement);

			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		//


	}
}
