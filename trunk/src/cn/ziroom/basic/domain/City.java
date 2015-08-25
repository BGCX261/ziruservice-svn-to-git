package cn.ziroom.basic.domain;

public class City implements java.io.Serializable {

	private static final long serialVersionUID = -5429903378762463071L;

	private Integer cityId;

	private String provinceHeader;

	private String cityName;

	private String cityCode;
	
	private String flag;
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getProvinceHeader() {
		return provinceHeader;
	}

	public void setProvinceHeader(String provinceHeader) {
		this.provinceHeader = provinceHeader == null ? null : provinceHeader.trim();
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode == null ? null : cityCode.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}