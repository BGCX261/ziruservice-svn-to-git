package cn.ziroom.contract.data;

import java.io.Serializable;

/**
 * 房间物品配置信息
 * 
 * @author Administrator
 * 
 */
public class ConfigData implements Serializable {

	private static final long serialVersionUID = 2212794934779685143L;

	private String houseCode;
	private String roomCode;
	private String itemCode;
	private String itemName;
	private String itemBrand;
	private Integer itemNum;
	private String itemUnit;
	private String itemUseYears;
	private String itemDesc;
	private String itemType;
	private String itemSpac;
	private String pictUrl;
	private String flag;
	private Integer sysRoomId;
	private Integer sysHouseId;

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
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
		this.itemUnit = itemUnit;
	}

	public String getItemUseYears() {
		return itemUseYears;
	}

	public void setItemUseYears(String itemUseYears) {
		this.itemUseYears = itemUseYears;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemSpac() {
		return itemSpac;
	}

	public void setItemSpac(String itemSpac) {
		this.itemSpac = itemSpac;
	}

	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
