package cn.ziroom.contract.data;

import java.io.Serializable;

/**
 * 房屋/房间区域实体类
 * 
 * @author Administrator
 * 
 */
public class RegionData implements Serializable {

	private static final long serialVersionUID = 1349235120014174366L;

	private String regionType;
	private Float regionLength;
	private Float regionWidth;
	private Float regionHeight;
	private String regionComment;
	// 客厅描述信息
	private String saloonMaterial;
	private String saloonMaster;
	private String saloonPosition;
	// 厨房描述信息
	private String kitchenStove;
	private String kitchenGastype;
	// 卫生间描述信息
	private String tolietExist;
	private String toiletWindow;
	private String toiletCurtain;
	private String toiletFan;
	// 阳台描述信息
	private String balconyExist;
	private String balconyType;
	// 花园描述信息
	private String garderExist;
	private String gardenType;
	private String gardenClay;
	
	private String terraceExist;

	public String getRegionType() {
		return regionType;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public Float getRegionLength() {
		return regionLength;
	}

	public void setRegionLength(Float regionLength) {
		this.regionLength = regionLength;
	}

	public Float getRegionWidth() {
		return regionWidth;
	}

	public void setRegionWidth(Float regionWidth) {
		this.regionWidth = regionWidth;
	}

	public Float getRegionHeight() {
		return regionHeight;
	}

	public void setRegionHeight(Float regionHeight) {
		this.regionHeight = regionHeight;
	}

	public String getRegionComment() {
		return regionComment;
	}

	public void setRegionComment(String regionComment) {
		this.regionComment = regionComment;
	}

	public String getSaloonMaterial() {
		return saloonMaterial;
	}

	public void setSaloonMaterial(String saloonMaterial) {
		this.saloonMaterial = saloonMaterial;
	}

	public String getSaloonMaster() {
		return saloonMaster;
	}

	public void setSaloonMaster(String saloonMaster) {
		this.saloonMaster = saloonMaster;
	}

	public String getSaloonPosition() {
		return saloonPosition;
	}

	public void setSaloonPosition(String saloonPosition) {
		this.saloonPosition = saloonPosition;
	}

	public String getKitchenStove() {
		return kitchenStove;
	}

	public void setKitchenStove(String kitchenStove) {
		this.kitchenStove = kitchenStove;
	}

	public String getKitchenGastype() {
		return kitchenGastype;
	}

	public void setKitchenGastype(String kitchenGastype) {
		this.kitchenGastype = kitchenGastype;
	}

	public String getToiletWindow() {
		return toiletWindow;
	}

	public void setToiletWindow(String toiletWindow) {
		this.toiletWindow = toiletWindow;
	}

	public String getToiletCurtain() {
		return toiletCurtain;
	}

	public void setToiletCurtain(String toiletCurtain) {
		this.toiletCurtain = toiletCurtain;
	}

	public String getToiletFan() {
		return toiletFan;
	}

	public void setToiletFan(String toiletFan) {
		this.toiletFan = toiletFan;
	}

	public String getBalconyType() {
		return balconyType;
	}

	public void setBalconyType(String balconyType) {
		this.balconyType = balconyType;
	}

	public String getGardenType() {
		return gardenType;
	}

	public void setGardenType(String gardenType) {
		this.gardenType = gardenType;
	}

	public String getGardenClay() {
		return gardenClay;
	}

	public void setGardenClay(String gardenClay) {
		this.gardenClay = gardenClay;
	}

	public String getTolietExist() {
		return tolietExist;
	}

	public void setTolietExist(String tolietExist) {
		this.tolietExist = tolietExist;
	}

	public String getBalconyExist() {
		return balconyExist;
	}

	public void setBalconyExist(String balconyExist) {
		this.balconyExist = balconyExist;
	}

	public String getGarderExist() {
		return garderExist;
	}

	public void setGarderExist(String garderExist) {
		this.garderExist = garderExist;
	}

	public String getTerraceExist() {
		return terraceExist;
	}

	public void setTerraceExist(String terraceExist) {
		this.terraceExist = terraceExist;
	}
}
