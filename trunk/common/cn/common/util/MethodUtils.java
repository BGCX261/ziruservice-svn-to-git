/*
 * 类说明：
 * 作者：孙树林
 * 创建日期：2010-11-9
 */
package cn.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author 孙树林
 * 
 */
public class MethodUtils {

	/**
	 * 验证方法及类是否为public
	 * 
	 * @param clazz
	 * @param method
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Method getAccessibleMethod(Class clazz, Method method) {
		if (method == null) {
			return null;
		}
		// 是否为public
		if (!Modifier.isPublic(method.getModifiers())) {
			return null;
		}
		// 是否为public class
		if (Modifier.isPublic(clazz.getModifiers())) {
			return method;
		}
		return null;
	}

	/**
	 * 执行方法
	 * 
	 * @param obj
	 * @param method
	 * @param parameters
	 * @param parameterTypes
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object invokeMethod(Object object, Method method, Object parameters, Class parameterTypes) {
		try {
			return method.invoke(object, parameters, parameterTypes);
		} catch (IllegalAccessException iae) {
			throw new IllegalArgumentException(iae.fillInStackTrace());
		} catch (InvocationTargetException ite) {
			throw new IllegalArgumentException(ite.fillInStackTrace());
		}
	}

	/**
	 * 执行方法
	 * 
	 * @param obj
	 * @param method
	 * @return
	 */
	public static Object invokeMethod(Object object, Method method, Object parameter) {
		try {
			return method.invoke(object, parameter);
		} catch (IllegalAccessException iae) {
			throw new IllegalArgumentException(iae.fillInStackTrace());
		} catch (InvocationTargetException ite) {
			throw new IllegalArgumentException(ite.fillInStackTrace());
		}
	}

	/**
	 * 执行方法
	 * 
	 * @param obj
	 * @param method
	 * @return
	 */
	public static Object invokeMethod(Object object, Method method) {
		try {
			return method.invoke(object);
		} catch (IllegalAccessException iae) {
			throw new IllegalArgumentException(iae.fillInStackTrace());
		} catch (InvocationTargetException ite) {
			throw new IllegalArgumentException(ite.fillInStackTrace());
		}
	}
}
