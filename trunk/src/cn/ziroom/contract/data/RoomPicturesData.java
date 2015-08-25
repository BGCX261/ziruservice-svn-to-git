package cn.ziroom.contract.data;

import java.io.Serializable;

/**
 * 房间图片实体
 * 
 * @author Administrator
 * 
 */
public class RoomPicturesData implements Serializable {

	private static final long serialVersionUID = -1305786409486596276L;

	private String houseCode;
	private String roomCode;
	private Integer imagetype;
	private String imagepath;
	private String imageCate;
	private String imageCode;
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

	public Integer getImagetype() {
		return imagetype;
	}

	public void setImagetype(Integer imagetype) {
		this.imagetype = imagetype;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getImageCate() {
		return imageCate;
	}

	public void setImageCate(String imageCate) {
		this.imageCate = imageCate;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
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
