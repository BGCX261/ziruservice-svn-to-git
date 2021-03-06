package cn.ziroom.contract.domain;

public class Config implements java.io.Serializable {

	private static final long serialVersionUID = 3523432433203656355L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.id
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.house_code
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String houseCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.room_code
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String roomCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_code
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_name
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_brand
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemBrand;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_num
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private Integer itemNum;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_unit
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemUnit;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_use_years
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemUseYears;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_desc
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_type
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.item_spac
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String itemSpac;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.pict_url
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String pictUrl;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_config.flag
	 * 
	 * @mbggenerated Tue Dec 13 11:53:45 CST 2011
	 */
	private String flag;
	
	private Integer sysRoomId;
	private Integer sysHouseId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode == null ? null : houseCode.trim();
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode == null ? null : roomCode.trim();
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode == null ? null : itemCode.trim();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand == null ? null : itemBrand.trim();
	}

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit == null ? null : itemUnit.trim();
	}

	public String getItemUseYears() {
		return itemUseYears;
	}

	public void setItemUseYears(String itemUseYears) {
		this.itemUseYears = itemUseYears == null ? null : itemUseYears.trim();
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc == null ? null : itemDesc.trim();
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType == null ? null : itemType.trim();
	}

	public String getItemSpac() {
		return itemSpac;
	}

	public void setItemSpac(String itemSpac) {
		this.itemSpac = itemSpac == null ? null : itemSpac.trim();
	}

	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl == null ? null : pictUrl.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public Integer getSysRoomId() {
		return sysRoomId;
	}

	public void setSysRoomId(Integer sysRoomId) {
		this.sysRoomId = sysRoomId;
	}

	public Integer getSysHouseId() {
		return sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}
}