package cn.ziroom.basic.domain;

import java.io.Serializable;

/**
 * 数据字典的POJO
 * 
 * @author manguo
 *
 */
public class Dict implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dType;
	private String dCode;
	private String dValue;
	
	public Dict(){
		
	}
	public Dict(String type, String code, String value){
		this.dType = type;
		this.dCode = code;
		this.dValue = value;
	}
	
	public String getdType() {
		return dType;
	}
	public void setdType(String dType) {
		this.dType = dType;
	}
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String code) {
		this.dCode = code;
	}
	public String getdValue() {
		return dValue;
	}
	public void setdValue(String dValue) {
		this.dValue = dValue;
	}
	
	
}
