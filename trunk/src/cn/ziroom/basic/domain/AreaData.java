package cn.ziroom.basic.domain;

import java.io.Serializable;

/**
 * 小区环线，商圈，周边设施等数据
 * 
 * @author Administrator
 * 
 */
public class AreaData implements Serializable {

	private static final long serialVersionUID = -1925017507271761275L;
	/** 类型：I插入，U更新，D删除 */
	private String operation;
	/** 名称 */
	private String name;
	/** 经度 */
	private float longitude;
	/** 纬度 */
	private float latitude;
	/** 编码 */
	private String code;

	public AreaData() {
		super();
	}

	public AreaData(String operation, String name, float longitude, float latitude, String code) {
		super();
		this.operation = operation;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.code = code;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
