package cn.ziroom.contract.domain;

import java.util.Date;

public class Room implements java.io.Serializable {

	private static final long serialVersionUID = 905631072917872056L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_id
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Integer roomId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_code
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_name
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.house_code
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String houseCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_type
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_area
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float roomArea;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_position
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomPosition;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.rent_fee
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Long rentFee;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.pay_way
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String payWay;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.noise_effect
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String noiseEffect;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.agent_phone
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String agentPhone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.agent_name
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String agentName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.steward_name
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String stewardName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.steward_phone
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String stewardPhone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_comment
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomComment;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float saloonLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float saloonWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float saloonHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_total
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float saloonTotal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_material
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String saloonMaterial;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_master
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String saloonMaster;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_position
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String saloonPosition;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.saloon_desc
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String saloonDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float kitchenLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float kitchenWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float kitchenHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_total
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float kitchenTotal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_stove
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String kitchenStove;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_gastype
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String kitchenGastype;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.kitchen_desc
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String kitchenDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toliet_exist
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String tolietExist;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float toiletLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float toiletWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float toiletHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_total
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float toiletTotal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_window
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String toiletWindow;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_curtain
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String toiletCurtain;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_fan
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String toiletFan;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.toilet_desc
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String toiletDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_exist
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String balconyExist;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float balconyLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float balconyWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float balconyHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_total
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float balconyTotal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_type
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String balconyType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.balcony_desc
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String balconyDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garder_exist
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String garderExist;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float gardenLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float gardenWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float gardenHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_total
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float gardenTotal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_type
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String gardenType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_clay
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String gardenClay;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.garden_desc
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String gardenDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.terrace_exist
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String terraceExist;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.terrace_length
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float terraceLength;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.terrace_width
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float terraceWidth;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.terrace_height
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float terraceHeight;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.terrace_total
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Float terraceTotal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.terrace_desc
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String terraceDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.check_in_time
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private Date checkInTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.is_top
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String isTop;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.is_show
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String isShow;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.is_available
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String isAvailable;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.is_promotions
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String isPromotions;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.rent_status
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String rentStatus;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.room_status
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String roomStatus;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.cust_sex
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String custSex;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.cust_code
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String custCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column t_room.flag
	 * 
	 * @mbggenerated Mon Dec 12 16:25:44 CST 2011
	 */
	private String flag;
	
	private Integer sysRoomId;
	private Integer sysHouseId;
	private Integer radomNum;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode == null ? null : roomCode.trim();
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName == null ? null : roomName.trim();
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode == null ? null : houseCode.trim();
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType == null ? null : roomType.trim();
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
		this.roomPosition = roomPosition == null ? null : roomPosition.trim();
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
		this.payWay = payWay == null ? null : payWay.trim();
	}

	public String getNoiseEffect() {
		return noiseEffect;
	}

	public void setNoiseEffect(String noiseEffect) {
		this.noiseEffect = noiseEffect == null ? null : noiseEffect.trim();
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone == null ? null : agentPhone.trim();
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName == null ? null : agentName.trim();
	}

	public String getStewardName() {
		return stewardName;
	}

	public void setStewardName(String stewardName) {
		this.stewardName = stewardName == null ? null : stewardName.trim();
	}

	public String getStewardPhone() {
		return stewardPhone;
	}

	public void setStewardPhone(String stewardPhone) {
		this.stewardPhone = stewardPhone == null ? null : stewardPhone.trim();
	}

	public String getRoomLength() {
		return roomLength;
	}

	public void setRoomLength(String roomLength) {
		this.roomLength = roomLength == null ? null : roomLength.trim();
	}

	public String getRoomWidth() {
		return roomWidth;
	}

	public void setRoomWidth(String roomWidth) {
		this.roomWidth = roomWidth == null ? null : roomWidth.trim();
	}

	public String getRoomHeight() {
		return roomHeight;
	}

	public void setRoomHeight(String roomHeight) {
		this.roomHeight = roomHeight == null ? null : roomHeight.trim();
	}

	public String getRoomComment() {
		return roomComment;
	}

	public void setRoomComment(String roomComment) {
		this.roomComment = roomComment == null ? null : roomComment.trim();
	}

	public Float getSaloonLength() {
		return saloonLength;
	}

	public void setSaloonLength(Float saloonLength) {
		this.saloonLength = saloonLength;
	}

	public Float getSaloonWidth() {
		return saloonWidth;
	}

	public void setSaloonWidth(Float saloonWidth) {
		this.saloonWidth = saloonWidth;
	}

	public Float getSaloonHeight() {
		return saloonHeight;
	}

	public void setSaloonHeight(Float saloonHeight) {
		this.saloonHeight = saloonHeight;
	}

	public Float getSaloonTotal() {
		return saloonTotal;
	}

	public void setSaloonTotal(Float saloonTotal) {
		this.saloonTotal = saloonTotal;
	}

	public String getSaloonMaterial() {
		return saloonMaterial;
	}

	public void setSaloonMaterial(String saloonMaterial) {
		this.saloonMaterial = saloonMaterial == null ? null : saloonMaterial.trim();
	}

	public String getSaloonMaster() {
		return saloonMaster;
	}

	public void setSaloonMaster(String saloonMaster) {
		this.saloonMaster = saloonMaster == null ? null : saloonMaster.trim();
	}

	public String getSaloonPosition() {
		return saloonPosition;
	}

	public void setSaloonPosition(String saloonPosition) {
		this.saloonPosition = saloonPosition == null ? null : saloonPosition.trim();
	}

	public String getSaloonDesc() {
		return saloonDesc;
	}

	public void setSaloonDesc(String saloonDesc) {
		this.saloonDesc = saloonDesc == null ? null : saloonDesc.trim();
	}

	public Float getKitchenLength() {
		return kitchenLength;
	}

	public void setKitchenLength(Float kitchenLength) {
		this.kitchenLength = kitchenLength;
	}

	public Float getKitchenWidth() {
		return kitchenWidth;
	}

	public void setKitchenWidth(Float kitchenWidth) {
		this.kitchenWidth = kitchenWidth;
	}

	public Float getKitchenHeight() {
		return kitchenHeight;
	}

	public void setKitchenHeight(Float kitchenHeight) {
		this.kitchenHeight = kitchenHeight;
	}

	public Float getKitchenTotal() {
		return kitchenTotal;
	}

	public void setKitchenTotal(Float kitchenTotal) {
		this.kitchenTotal = kitchenTotal;
	}

	public String getKitchenStove() {
		return kitchenStove;
	}

	public void setKitchenStove(String kitchenStove) {
		this.kitchenStove = kitchenStove == null ? null : kitchenStove.trim();
	}

	public String getKitchenGastype() {
		return kitchenGastype;
	}

	public void setKitchenGastype(String kitchenGastype) {
		this.kitchenGastype = kitchenGastype == null ? null : kitchenGastype.trim();
	}

	public String getKitchenDesc() {
		return kitchenDesc;
	}

	public void setKitchenDesc(String kitchenDesc) {
		this.kitchenDesc = kitchenDesc == null ? null : kitchenDesc.trim();
	}

	public String getTolietExist() {
		return tolietExist;
	}

	public void setTolietExist(String tolietExist) {
		this.tolietExist = tolietExist == null ? null : tolietExist.trim();
	}

	public Float getToiletLength() {
		return toiletLength;
	}

	public void setToiletLength(Float toiletLength) {
		this.toiletLength = toiletLength;
	}

	public Float getToiletWidth() {
		return toiletWidth;
	}

	public void setToiletWidth(Float toiletWidth) {
		this.toiletWidth = toiletWidth;
	}

	public Float getToiletHeight() {
		return toiletHeight;
	}

	public void setToiletHeight(Float toiletHeight) {
		this.toiletHeight = toiletHeight;
	}

	public Float getToiletTotal() {
		return toiletTotal;
	}

	public void setToiletTotal(Float toiletTotal) {
		this.toiletTotal = toiletTotal;
	}

	public String getToiletWindow() {
		return toiletWindow;
	}

	public void setToiletWindow(String toiletWindow) {
		this.toiletWindow = toiletWindow == null ? null : toiletWindow.trim();
	}

	public String getToiletCurtain() {
		return toiletCurtain;
	}

	public void setToiletCurtain(String toiletCurtain) {
		this.toiletCurtain = toiletCurtain == null ? null : toiletCurtain.trim();
	}

	public String getToiletFan() {
		return toiletFan;
	}

	public void setToiletFan(String toiletFan) {
		this.toiletFan = toiletFan == null ? null : toiletFan.trim();
	}

	public String getToiletDesc() {
		return toiletDesc;
	}

	public void setToiletDesc(String toiletDesc) {
		this.toiletDesc = toiletDesc == null ? null : toiletDesc.trim();
	}

	public String getBalconyExist() {
		return balconyExist;
	}

	public void setBalconyExist(String balconyExist) {
		this.balconyExist = balconyExist == null ? null : balconyExist.trim();
	}

	public Float getBalconyLength() {
		return balconyLength;
	}

	public void setBalconyLength(Float balconyLength) {
		this.balconyLength = balconyLength;
	}

	public Float getBalconyWidth() {
		return balconyWidth;
	}

	public void setBalconyWidth(Float balconyWidth) {
		this.balconyWidth = balconyWidth;
	}

	public Float getBalconyHeight() {
		return balconyHeight;
	}

	public void setBalconyHeight(Float balconyHeight) {
		this.balconyHeight = balconyHeight;
	}

	public Float getBalconyTotal() {
		return balconyTotal;
	}

	public void setBalconyTotal(Float balconyTotal) {
		this.balconyTotal = balconyTotal;
	}

	public String getBalconyType() {
		return balconyType;
	}

	public void setBalconyType(String balconyType) {
		this.balconyType = balconyType == null ? null : balconyType.trim();
	}

	public String getBalconyDesc() {
		return balconyDesc;
	}

	public void setBalconyDesc(String balconyDesc) {
		this.balconyDesc = balconyDesc == null ? null : balconyDesc.trim();
	}

	public String getGarderExist() {
		return garderExist;
	}

	public void setGarderExist(String garderExist) {
		this.garderExist = garderExist == null ? null : garderExist.trim();
	}

	public Float getGardenLength() {
		return gardenLength;
	}

	public void setGardenLength(Float gardenLength) {
		this.gardenLength = gardenLength;
	}

	public Float getGardenWidth() {
		return gardenWidth;
	}

	public void setGardenWidth(Float gardenWidth) {
		this.gardenWidth = gardenWidth;
	}

	public Float getGardenHeight() {
		return gardenHeight;
	}

	public void setGardenHeight(Float gardenHeight) {
		this.gardenHeight = gardenHeight;
	}

	public Float getGardenTotal() {
		return gardenTotal;
	}

	public void setGardenTotal(Float gardenTotal) {
		this.gardenTotal = gardenTotal;
	}

	public String getGardenType() {
		return gardenType;
	}

	public void setGardenType(String gardenType) {
		this.gardenType = gardenType == null ? null : gardenType.trim();
	}

	public String getGardenClay() {
		return gardenClay;
	}

	public void setGardenClay(String gardenClay) {
		this.gardenClay = gardenClay == null ? null : gardenClay.trim();
	}

	public String getGardenDesc() {
		return gardenDesc;
	}

	public void setGardenDesc(String gardenDesc) {
		this.gardenDesc = gardenDesc == null ? null : gardenDesc.trim();
	}

	public String getTerraceExist() {
		return terraceExist;
	}

	public void setTerraceExist(String terraceExist) {
		this.terraceExist = terraceExist == null ? null : terraceExist.trim();
	}

	public Float getTerraceLength() {
		return terraceLength;
	}

	public void setTerraceLength(Float terraceLength) {
		this.terraceLength = terraceLength;
	}

	public Float getTerraceWidth() {
		return terraceWidth;
	}

	public void setTerraceWidth(Float terraceWidth) {
		this.terraceWidth = terraceWidth;
	}

	public Float getTerraceHeight() {
		return terraceHeight;
	}

	public void setTerraceHeight(Float terraceHeight) {
		this.terraceHeight = terraceHeight;
	}

	public Float getTerraceTotal() {
		return terraceTotal;
	}

	public void setTerraceTotal(Float terraceTotal) {
		this.terraceTotal = terraceTotal;
	}

	public String getTerraceDesc() {
		return terraceDesc;
	}

	public void setTerraceDesc(String terraceDesc) {
		this.terraceDesc = terraceDesc == null ? null : terraceDesc.trim();
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop == null ? null : isTop.trim();
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow == null ? null : isShow.trim();
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable == null ? null : isAvailable.trim();
	}

	public String getIsPromotions() {
		return isPromotions;
	}

	public void setIsPromotions(String isPromotions) {
		this.isPromotions = isPromotions == null ? null : isPromotions.trim();
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus == null ? null : rentStatus.trim();
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus == null ? null : roomStatus.trim();
	}

	public String getCustSex() {
		return custSex;
	}

	public void setCustSex(String custSex) {
		this.custSex = custSex == null ? null : custSex.trim();
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode == null ? null : custCode.trim();
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

	public Integer getRadomNum() {
		return radomNum;
	}

	public void setRadomNum(Integer radomNum) {
		this.radomNum = radomNum;
	}
}