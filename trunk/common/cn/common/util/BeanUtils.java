/*
 * 类说明：
 * 作者：孙树林
 * 创建日期：2010-11-9
 */
package cn.common.util;

import java.beans.PropertyDescriptor;

/**
 * @author 孙树林
 * 
 */
public class BeanUtils {

	/**
	 * 属性复制
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyProperties(Object source, Object target) {
		// 目标对象属性
		PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(target);
		for (int i = 0; i < descriptors.length; i++) {
			PropertyDescriptor pd = descriptors[i];
			String name = pd.getName();
			if (StringUtils.equalsignIgnoreCase(name, "class")) {
				continue;
			}
			// 源目标对象中通过属性查找值
			Object value = PropertyUtils.getPropertyValue(source, name);
			if (value != null) {
				// 写入目的对象属性中
				copyProperty(target, name, value);
			}
		}
	}

	/**
	 * 值拷贝到目标对象属性
	 * 
	 * @param target
	 * @param name
	 * @param value
	 */
	public static void copyProperty(Object target, String name, Object value) {
		PropertyUtils.setPropertyValue(target, name, value);
	}

}
