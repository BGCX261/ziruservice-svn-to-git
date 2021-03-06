package cn.ziroom.basic.domain;

public class Subway implements java.io.Serializable {

	private static final long serialVersionUID = -8493749154857758119L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_subway.subway_id
	 * 
	 * @mbggenerated Thu Dec 01 14:59:57 CST 2011
	 */
	private Integer subwayId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_subway.city_code
	 * 
	 * @mbggenerated Thu Dec 01 14:59:57 CST 2011
	 */
	private String cityCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_subway.subway_name
	 * 
	 * @mbggenerated Thu Dec 01 14:59:57 CST 2011
	 */
	private String subwayName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_subway.subway_code
	 * 
	 * @mbggenerated Thu Dec 01 14:59:57 CST 2011
	 */
	private String subwayCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_subway.subway_desc
	 * 
	 * @mbggenerated Thu Dec 01 14:59:57 CST 2011
	 */
	private String subwayDesc;
	
	private String flag;

	public Integer getSubwayId() {
		return subwayId;
	}

	public void setSubwayId(Integer subwayId) {
		this.subwayId = subwayId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode == null ? null : cityCode.trim();
	}

	public String getSubwayName() {
		return subwayName;
	}

	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName == null ? null : subwayName.trim();
	}

	public String getSubwayCode() {
		return subwayCode;
	}

	public void setSubwayCode(String subwayCode) {
		this.subwayCode = subwayCode == null ? null : subwayCode.trim();
	}

	public String getSubwayDesc() {
		return subwayDesc;
	}

	public void setSubwayDesc(String subwayDesc) {
		this.subwayDesc = subwayDesc == null ? null : subwayDesc.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}