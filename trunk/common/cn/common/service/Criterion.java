package cn.common.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 查询条件类
 * 
 * @author 孙树林
 * 
 */
public class Criterion implements Serializable {

	private static final long serialVersionUID = -7508980024982885485L;

	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/** 字段名称 */
	private String field;
	/** sql条件 */
	private String conditionType;
	/** 生成条件串 */
	private String condition;
	/** 第一个值 */
	private Object value;
	/** 第二个值 */
	private Object secondValue;
	/** 没有值标识 */
	private boolean noValue;
	/** 标识符 */
	private boolean singleValue;
	/** between */
	private boolean betweenValue;
	/** 多个值 */
	private boolean listValue;
	/** sql条件 */
	private String typeHandler;

	public Criterion() {
		super();
	}

	public Criterion(String field, String conditionType, Object value, String typeHandler) {
		super();
		this.field = field;
		this.conditionType = conditionType;
		this.value = value;
		this.typeHandler = typeHandler;
		this.createCondition(field, conditionType, value, null, typeHandler);
	}

	public Criterion(String field, String conditionType, Object value, Object secondValue, String typeHandler) {
		super();
		this.field = field;
		this.conditionType = conditionType;
		this.value = value;
		this.secondValue = secondValue;
		this.typeHandler = typeHandler;
		this.createCondition(field, conditionType, value, secondValue, typeHandler);
	}

	public void createCondition() {
		StringBuilder sb = new StringBuilder(field);
		sb.append(conditionType);
		if (conditionType.equals(Single.ISNOTNULL) || conditionType.equals(Single.ISNULL)) {
			this.noValue = true;
		} else if (conditionType.equals(Single.BETWEEN) || conditionType.equals(Single.NOTBETWEEN)) {
			this.betweenValue = true;
			this.valueConverter(value, secondValue, conditionType);
		} else if (conditionType.equals(Single.IN) || conditionType.equals(Single.NOTIN)) {
			this.listValue = true;
		} else {
			this.singleValue = true;
			this.valueConverter(value, conditionType);
		}
		this.condition = sb.toString();
	}

	/**
	 * 构建查询条件
	 * 
	 * @param field
	 * @param conditionType
	 * @param value
	 * @param secondValue
	 * @param typeHandler
	 */
	private void createCondition(String field, String conditionType, Object value, Object secondValue, String typeHandler) {
		StringBuilder sb = new StringBuilder(field);
		sb.append(conditionType);
		if (conditionType.equals(Single.ISNOTNULL) || conditionType.equals(Single.ISNULL)) {
			this.noValue = true;
		} else if (conditionType.equals(Single.BETWEEN) || conditionType.equals(Single.NOTBETWEEN)) {
			this.betweenValue = true;
			this.valueConverter(value, secondValue, conditionType);
		} else if (conditionType.equals(Single.IN) || conditionType.equals(Single.NOTIN)) {
			this.listValue = true;
		} else {
			this.singleValue = true;
			this.valueConverter(secondValue, conditionType);
		}
		this.condition = sb.toString();
	}

	/**
	 * 类型转换
	 * 
	 * @param value
	 * @param type
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void valueConverter(Object value, String type) {
		if (type.equals(Single.IN) || type.equals(Single.NOTIN)) {
			if (value instanceof List) {
				List values = (List) value;
				Iterator iterator = values.iterator();
				List list = new ArrayList();
				while (iterator.hasNext()) {
					list.add(conver(iterator.next(), type));
				}
				this.value = list;
			} else {
				this.value = conver(value, type);
			}
		} else {
			this.value = conver(value, type);
		}
	}

	/**
	 * 类型转换
	 * 
	 * @param value
	 * @param type
	 */
	private void valueConverter(Object value, Object secondValue, String type) {
		this.value = conver(value, type);
		this.secondValue = conver(secondValue, type);
	}

	/**
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	private Object conver(Object value, String type) {
		if (value instanceof String[]) {
			value = ((String[]) value)[0];
		}
		if (type.equals(Single.STRING)) {
			value = String.valueOf(value);
		} else if (type.equals(Single.INTEGER)) {
			value = Integer.parseInt(String.valueOf(value));
		} else if (type.equals(Single.DATE)) {
			try {
				value = new java.sql.Date((df.parse(String.valueOf(value))).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (type.equals(Single.REAL)) {
			value = new BigDecimal(String.valueOf(value));
		}
		return value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Object secondValue) {
		this.secondValue = secondValue;
	}

	public boolean isNoValue() {
		return noValue;
	}

	public void setNoValue(boolean noValue) {
		this.noValue = noValue;
	}

	public boolean isSingleValue() {
		return singleValue;
	}

	public void setSingleValue(boolean singleValue) {
		this.singleValue = singleValue;
	}

	public boolean isBetweenValue() {
		return betweenValue;
	}

	public void setBetweenValue(boolean betweenValue) {
		this.betweenValue = betweenValue;
	}

	public boolean isListValue() {
		return listValue;
	}

	public void setListValue(boolean listValue) {
		this.listValue = listValue;
	}

	public String getTypeHandler() {
		return typeHandler;
	}

	public void setTypeHandler(String typeHandler) {
		this.typeHandler = typeHandler;
	}

}
