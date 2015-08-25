package cn.ziroom.contract.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 收/出房合同实体
 * 
 * @author Administrator
 * 
 */
public class ContractData implements Serializable {

	private static final long serialVersionUID = 207739808321203775L;

	private String custCode;
	private String houseCode;
	private String roomCode;
	private String contractCode;
	private String securityCode;
	private String cycle;
	private String vacancy;
	private Date signDate;
	private Date effectDate;
	private Date stopDate;
	private BigDecimal price;
	private String storeNum;
	private String storeName;
	private String businessName;
	private String areaName;
	private String storeLeaderCode;
	private String storeLeaderName;
	private String storeAgentCode;
	private String storeAgentName;
	private String agentCode;
	private String houseProduct;
	private String rental;
	private String payment;
	private String contractState;
	private Integer sysContractId;
	private Integer sysRoomId;
	private Integer sysHouseId;
	private Integer sysCustId;
	private String contractType;

	private HouseData houseData;
	
	private CustomerData customerData;

	private List<RoomData> roomList = new ArrayList<RoomData>();

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

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

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStoreLeaderCode() {
		return storeLeaderCode;
	}

	public void setStoreLeaderCode(String storeLeaderCode) {
		this.storeLeaderCode = storeLeaderCode;
	}

	public String getStoreLeaderName() {
		return storeLeaderName;
	}

	public void setStoreLeaderName(String storeLeaderName) {
		this.storeLeaderName = storeLeaderName;
	}

	public String getStoreAgentCode() {
		return storeAgentCode;
	}

	public void setStoreAgentCode(String storeAgentCode) {
		this.storeAgentCode = storeAgentCode;
	}

	public String getStoreAgentName() {
		return storeAgentName;
	}

	public void setStoreAgentName(String storeAgentName) {
		this.storeAgentName = storeAgentName;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getHouseProduct() {
		return houseProduct;
	}

	public void setHouseProduct(String houseProduct) {
		this.houseProduct = houseProduct;
	}

	public String getRental() {
		return rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public HouseData getHouseData() {
		return houseData;
	}

	public void setHouseData(HouseData houseData) {
		this.houseData = houseData;
	}

	public List<RoomData> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomData> roomList) {
		this.roomList = roomList;
	}

	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	public CustomerData getCustomerData() {
		return customerData;
	}

	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}

	public Integer getSysContractId() {
		return sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
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

	public Integer getSysCustId() {
		return sysCustId;
	}

	public void setSysCustId(Integer sysCustId) {
		this.sysCustId = sysCustId;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
}
