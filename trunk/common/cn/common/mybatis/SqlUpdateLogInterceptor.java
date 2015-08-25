package cn.common.mybatis;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import cn.common.log.GeneralManager;
import cn.common.log.SqlLog;
import cn.common.util.PropertyUtils;

import com.google.gson.Gson;

/**
 * mybatis数据库操作语句拦截器，获得执行sql语句和执行参数
 * 
 * @author 孙树林
 * 
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class SqlUpdateLogInterceptor implements Interceptor {

	/**
	 * 用来保存insert,update,delete数据库操作语句及数据参数
	 * 
	 * @param invocation
	 * @return
	 * @throws Throwable
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		GeneralManager generalManager = GeneralManager.getCurrentManager();
		Object[] objs = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) objs[0];
		Object obj = objs[1];
		if (obj != null) {
			BoundSql boundSql = mappedStatement.getBoundSql(obj);
			String sql = boundSql.getSql().replaceAll("\\s+|\n|\t|\b", " ");
			int size = boundSql.getParameterMappings() != null ? boundSql.getParameterMappings().size() : 0;
			Map maps = new HashMap();
			for (int i = 0; i < size; i++) {
				ParameterMapping pm = boundSql.getParameterMappings().get(i);
				String parameterName = pm.getProperty();
				String parameterValue = PropertyUtils.getPropertyValue(obj, pm.getProperty()) != null ? String.valueOf(PropertyUtils.getPropertyValue(obj, pm.getProperty())) : "";
				maps.put(parameterName, parameterValue);
			}
			Gson json = new Gson();
			generalManager.addSql(new SqlLog(sql, json.toJson(maps)));
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
