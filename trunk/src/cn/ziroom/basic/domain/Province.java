package cn.ziroom.basic.domain;

/**
 * 省份信息表
 * 
 * @author Administrator
 */
public class Province implements java.io.Serializable {

	private static final long serialVersionUID = -5300246404854822284L;

	private Integer provinceId;

	private String provinceName;

	private String provinceCode;

	private String provinceShort;
	
	private String status;
	
	private String flag;

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName == null ? null : provinceName.trim();
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode == null ? null : provinceCode.trim();
	}

	public String getProvinceShort() {
		return provinceShort;
	}

	public void setProvinceShort(String provinceShort) {
		this.provinceShort = provinceShort == null ? null : provinceShort.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}