package cn.ziroom.contract.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 房间/公共区域信息实体类
 * 
 * @author Administrator
 * 
 */
public class RoomData implements Serializable {

	private static final long serialVersionUID = 149601928074201418L;

	private String roomCode;
	private String roomName;
	private String houseCode;
	private String roomType;
	// 卧室基本信息
	private Float roomArea;
	private String roomPosition;
	private Long rentFee;
	private String payWay;
	private String noiseEffect;
	private String roomLength;
	private String roomWidth;
	private String roomHeight;
	private String roomComment;
	// 房间状态
	private String roomStatus;
	private String rentStatus;
	private Integer sysRoomId;
	private Integer sysHouseId;
	private String flag;
	// 房间/公共区域信息
	private List<RegionData> regionDataList = new ArrayList<RegionData>();

	// 房间物品配置清单
	private List<ConfigData> configList = new ArrayList<ConfigData>();
	
	// 房间图片
	private List<RoomPicturesData> pictList = new ArrayList<RoomPicturesData>();
	
	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Float getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Float roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomPosition() {
		return roomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}

	public Long getRentFee() {
		return rentFee;
	}

	public void setRentFee(Long rentFee) {
		this.rentFee = rentFee;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getNoiseEffect() {
		return noiseEffect;
	}

	public void setNoiseEffect(String noiseEffect) {
		this.noiseEffect = noiseEffect;
	}

	public String getRoomLength() {
		return roomLength;
	}

	public void setRoomLength(String roomLength) {
		this.roomLength = roomLength;
	}

	public String getRoomWidth() {
		return roomWidth;
	}

	public void setRoomWidth(String roomWidth) {
		this.roomWidth = roomWidth;
	}

	public String getRoomHeight() {
		return roomHeight;
	}

	public void setRoomHeight(String roomHeight) {
		this.roomHeight = roomHeight;
	}

	public String getRoomComment() {
		return roomComment;
	}

	public void setRoomComment(String roomComment) {
		this.roomComment = roomComment;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public List<RegionData> getRegionDataList() {
		return regionDataList;
	}

	public void setRegionDataList(List<RegionData> regionDataList) {
		this.regionDataList = regionDataList;
	}

	public List<ConfigData> getConfigList() {
		return configList;
	}

	public void setConfigList(List<ConfigData> configList) {
		this.configList = configList;
	}

	public List<RoomPicturesData> getPictList() {
		return pictList;
	}

	public void setPictList(List<RoomPicturesData> pictList) {
		this.pictList = pictList;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
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
