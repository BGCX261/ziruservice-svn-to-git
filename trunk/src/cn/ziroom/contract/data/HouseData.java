package cn.ziroom.contract.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 房屋信息实体类
 * 
 * @author Administrator
 * 
 */
public class HouseData implements Serializable {

	private static final long serialVersionUID = -5716016912781664113L;

	private String title;
	private String houseCode;
	private String dictHouseCode;
	private String province;
	private String city;
	private String cycle;
	private String cycleFace;
	private String counties;
	private String shopping;
	private String subwayStations;
	private String subwayLine;
	private String projectcode;
	private String building;
	private String unit;
	private String floor;
	private String totalFloor;
	private String houseNumber;
	private String buildType;
	private String originalBuildType;
	private String houseFace;
	private String houseArea;
	private String heating;
	private Integer decorateLivingNum;
	private Integer decorateBedroomNum;
	private Integer decorateKitchenNum;
	private Integer decorateBathroomNum;
	private Integer decorateBalcony;
	private Integer decorateGarden;
	private Integer decorateGazebo;
	private Long payment;
	private String houseEvaluate;
	private String environmentEvaluate;
	private String characteristics;
	private String rentType;
	private Integer assistantCode;
	private String agentPhone;
	private String agentName;
	private String stewardCode;
	private String stewardName;
	private String stewardPhone;
	private String leaderCode;
	private String broadband;
	private Integer ladder;
	private Integer household;
	private String customerPay;
	private String houseProduct;
	private Integer sysHouseId;
	private Integer sysContractId;

	// 房屋状态
	private String houseStatus;
	private String rentStatus;
	private String flag;
	
	private Integer walktime;
    private String busstation;
    private String buscode;

	private List<RoomData> roomData = new ArrayList<RoomData>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getDictHouseCode() {
		return dictHouseCode;
	}

	public void setDictHouseCode(String dictHouseCode) {
		this.dictHouseCode = dictHouseCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getCycleFace() {
		return cycleFace;
	}

	public void setCycleFace(String cycleFace) {
		this.cycleFace = cycleFace;
	}

	public String getCounties() {
		return counties;
	}

	public void setCounties(String counties) {
		this.counties = counties;
	}

	public String getShopping() {
		return shopping;
	}

	public void setShopping(String shopping) {
		this.shopping = shopping;
	}

	public String getSubwayStations() {
		return subwayStations;
	}

	public void setSubwayStations(String subwayStations) {
		this.subwayStations = subwayStations;
	}

	public String getSubwayLine() {
		return subwayLine;
	}

	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(String totalFloor) {
		this.totalFloor = totalFloor;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getOriginalBuildType() {
		return originalBuildType;
	}

	public void setOriginalBuildType(String originalBuildType) {
		this.originalBuildType = originalBuildType;
	}

	public String getHouseFace() {
		return houseFace;
	}

	public void setHouseFace(String houseFace) {
		this.houseFace = houseFace;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHeating() {
		return heating;
	}

	public void setHeating(String heating) {
		this.heating = heating;
	}

	public Integer getDecorateLivingNum() {
		return decorateLivingNum;
	}

	public void setDecorateLivingNum(Integer decorateLivingNum) {
		this.decorateLivingNum = decorateLivingNum;
	}

	public Integer getDecorateBedroomNum() {
		return decorateBedroomNum;
	}

	public void setDecorateBedroomNum(Integer decorateBedroomNum) {
		this.decorateBedroomNum = decorateBedroomNum;
	}

	public Integer getDecorateKitchenNum() {
		return decorateKitchenNum;
	}

	public void setDecorateKitchenNum(Integer decorateKitchenNum) {
		this.decorateKitchenNum = decorateKitchenNum;
	}

	public Integer getDecorateBathroomNum() {
		return decorateBathroomNum;
	}

	public void setDecorateBathroomNum(Integer decorateBathroomNum) {
		this.decorateBathroomNum = decorateBathroomNum;
	}

	public Integer getDecorateBalcony() {
		return decorateBalcony;
	}

	public void setDecorateBalcony(Integer decorateBalcony) {
		this.decorateBalcony = decorateBalcony;
	}

	public Integer getDecorateGarden() {
		return decorateGarden;
	}

	public void setDecorateGarden(Integer decorateGarden) {
		this.decorateGarden = decorateGarden;
	}

	public Integer getDecorateGazebo() {
		return decorateGazebo;
	}

	public void setDecorateGazebo(Integer decorateGazebo) {
		this.decorateGazebo = decorateGazebo;
	}

	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}

	public String getHouseEvaluate() {
		return houseEvaluate;
	}

	public void setHouseEvaluate(String houseEvaluate) {
		this.houseEvaluate = houseEvaluate;
	}

	public String getEnvironmentEvaluate() {
		return environmentEvaluate;
	}

	public void setEnvironmentEvaluate(String environmentEvaluate) {
		this.environmentEvaluate = environmentEvaluate;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public Integer getAssistantCode() {
		return assistantCode;
	}

	public void setAssistantCode(Integer assistantCode) {
		this.assistantCode = assistantCode;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getStewardCode() {
		return stewardCode;
	}

	public void setStewardCode(String stewardCode) {
		this.stewardCode = stewardCode;
	}

	public String getStewardName() {
		return stewardName;
	}

	public void setStewardName(String stewardName) {
		this.stewardName = stewardName;
	}

	public String getStewardPhone() {
		return stewardPhone;
	}

	public void setStewardPhone(String stewardPhone) {
		this.stewardPhone = stewardPhone;
	}

	public String getLeaderCode() {
		return leaderCode;
	}

	public void setLeaderCode(String leaderCode) {
		this.leaderCode = leaderCode;
	}

	public String getBroadband() {
		return broadband;
	}

	public void setBroadband(String broadband) {
		this.broadband = broadband;
	}

	public Integer getLadder() {
		return ladder;
	}

	public void setLadder(Integer ladder) {
		this.ladder = ladder;
	}

	public Integer getHousehold() {
		return household;
	}

	public void setHousehold(Integer household) {
		this.household = household;
	}

	public String getCustomerPay() {
		return customerPay;
	}

	public void setCustomerPay(String customerPay) {
		this.customerPay = customerPay;
	}

	public String getHouseStatus() {
		return houseStatus;
	}

	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}

	public String getHouseProduct() {
		return houseProduct;
	}

	public void setHouseProduct(String houseProduct) {
		this.houseProduct = houseProduct;
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

	public List<RoomData> getRoomData() {
		return roomData;
	}

	public void setRoomData(List<RoomData> roomData) {
		this.roomData = roomData;
	}

	public Integer getSysHouseId() {
		return sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}

	public Integer getSysContractId() {
		return sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
	}

	public Integer getWalktime() {
		return walktime;
	}

	public void setWalktime(Integer walktime) {
		this.walktime = walktime;
	}

	public String getBusstation() {
		return busstation;
	}

	public void setBusstation(String busstation) {
		this.busstation = busstation;
	}

	public String getBuscode() {
		return buscode;
	}

	public void setBuscode(String buscode) {
		this.buscode = buscode;
	}

}
