package org.anderneo.mybatis.utils;

import java.util.Collection;

/**
 * @author fan.yang
 * @date 2020/8/23 18:10
 */
public class CommonUtis {

	public static boolean isNotEmpty(Collection<?> collection) {
		return collection != null && !collection.isEmpty();
	}
}
