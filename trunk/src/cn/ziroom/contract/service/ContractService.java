package cn.ziroom.contract.service;

import java.util.List;

import cn.common.util.BeanUtils;
import cn.ziroom.contract.dao.HouseAndRoomDao;
import cn.ziroom.contract.data.ContractData;
import cn.ziroom.contract.data.CustomerData;
import cn.ziroom.contract.data.HouseData;
import cn.ziroom.contract.data.RegionData;
import cn.ziroom.contract.data.RoomData;
import cn.ziroom.contract.domain.Contract;
import cn.ziroom.contract.domain.Customer;
import cn.ziroom.contract.domain.House;
import cn.ziroom.contract.domain.Room;
import cn.ziroom.contract.mapper.ContractMapper;
import cn.ziroom.contract.mapper.CustomerMapper;
import cn.ziroom.contract.mapper.HouseMapper;
import cn.ziroom.contract.mapper.RoomMapper;
import cn.ziroom.system.mapper.UserMapper;
import cn.ziroom.util.CreateRadomNum;

/**
 * 收/出房合同业务处理类
 * 
 * @author Administrator
 * 
 */
public class ContractService {

	private ContractMapper contractMapper;		//合同对象

	private CustomerMapper customerMapper;		//客户对象

	private HouseMapper houseMapper;			//房屋对象

	private RoomMapper roomMapper;				//房间对象

	private HouseAndRoomDao houseAndRoomDao;	//房屋和房间关联关系对象
	
	private UserMapper userMapper;

	/**
	 * 收房合同业务流程数据同步处理方法
	 * 
	 * @param recive
	 */
	public String synchroReciveContract(ContractData recive) {
		/*
		String stewart = recive.getHouseData().getStewardCode();
		String c = userMapper.selectByCode(stewart);
		if(c == null) {
			System.out.println("[Error:]管家编号不存在");
			System.out.println("=======================================================================");
			System.out.println();
			return "[Error:] 管家编号不存在";
		}
		
		try{
			ContractValidate.validate(recive);
		}catch(Exception e){
			System.out.println("[Error:]" + e.getMessage());
			System.out.println("=======================================================================");
			System.out.println();
			return "[Error:]" + e.getMessage();
		}
		*/
		
		//step 1 获得收房合同的用户信息，根据客户编号查询客户是否存在
		CustomerData custData = recive.getCustomerData();

		String code = customerMapper.selectByCode(custData.getSysCustId());
		Customer customer = new Customer();
		BeanUtils.copyProperties(custData, customer);
		if (code == null) {
			customer.setCustType("YZ");
			// 保存客户资料信息
			customerMapper.insert(customer);
		} else {
			customerMapper.update(customer);
		}
		
		//step 2 保存合同信息，对于合同信息同步不做业务上验证。
		Contract contract = new Contract();

		BeanUtils.copyProperties(recive, contract);
		// 合同信息处理
		Contract a = contractMapper.selectByCode(contract);
		if (a != null) {
			contractMapper.update(contract);
		} else {
			contractMapper.insert(contract);
		}
		//String houseTitle = houseAndRoomDao.createHouseTitle(recive.getHouseData());
		// 保存房间信息
		List<RoomData> roomList = recive.getRoomList();
		for (RoomData rd : roomList) {

			Room r = new Room();
			
			BeanUtils.copyProperties(rd, r);
			// 房间扩展信息处理
			List<RegionData> regionDataList = rd.getRegionDataList();
			if (regionDataList != null) {
				for (RegionData region : regionDataList) {
					// 信息对应的相应的房间字典上
					if (region.getRegionType().equalsIgnoreCase("saloon")) {
						r.setSaloonLength(region.getRegionLength());
						r.setSaloonWidth(region.getRegionWidth());
						r.setSaloonHeight(region.getRegionHeight());
						r.setSaloonMaster(region.getSaloonMaster());
						r.setSaloonMaterial(region.getSaloonMaterial());
						r.setSaloonPosition(region.getSaloonPosition());
						r.setSaloonDesc(region.getRegionComment());
					} else if (region.getRegionType().equalsIgnoreCase("kitchen")) {
						r.setKitchenLength(region.getRegionLength());
						r.setKitchenWidth(region.getRegionWidth());
						r.setKitchenHeight(region.getRegionHeight());
						r.setKitchenGastype(region.getKitchenGastype());
						r.setKitchenStove(region.getKitchenStove());
						r.setKitchenDesc(region.getRegionComment());
					} else if (region.getRegionType().equalsIgnoreCase("toliet")) {
						r.setTolietExist("Y");
						r.setToiletLength(region.getRegionLength());
						r.setToiletWidth(region.getRegionWidth());
						r.setToiletHeight(region.getRegionHeight());
						r.setToiletCurtain(region.getToiletCurtain());
						r.setToiletFan(region.getToiletFan());
						r.setToiletWindow(region.getToiletWindow());
						r.setToiletDesc(region.getRegionComment());
					} else if (region.getRegionType().equalsIgnoreCase("balcony")) {
						r.setBalconyExist("Y");
						r.setBalconyLength(region.getRegionLength());
						r.setBalconyWidth(region.getRegionWidth());
						r.setBalconyHeight(region.getRegionHeight());
						r.setBalconyType(region.getBalconyType());
						r.setBalconyDesc(region.getRegionComment());
					} else if (region.getRegionType().equalsIgnoreCase("garder")) {
						r.setGarderExist("Y");
						r.setGardenLength(region.getRegionLength());
						r.setGardenWidth(region.getRegionWidth());
						r.setGardenHeight(region.getRegionHeight());
						r.setGardenType(region.getBalconyType());
						r.setGardenClay(region.getGardenClay());
						r.setGardenDesc(region.getRegionComment());
					} else if (region.getRegionType().equalsIgnoreCase("terrace")) {
						r.setTerraceExist("Y");
						r.setTerraceLength(region.getRegionLength());
						r.setTerraceWidth(region.getRegionWidth());
						r.setTerraceHeight(region.getRegionHeight());
						r.setTerraceDesc(region.getRegionComment());
					}
				}
			}
			Room rm = new Room();
			rm.setSysRoomId(rd.getSysRoomId());
			rm.setSysHouseId(rd.getSysHouseId());
			Room rc = roomMapper.selectByCode(rm);
			if(!r.getRoomType().equals("KITCHEN")) {				
				//r.setRoomName(houseAndRoomDao.createRoomTitle(houseTitle, r.getRoomPosition()));
			}
			if (rc != null) {//如果先前有房间信息， 则需要去修改存在房间的信息。
				//TODO 先处理：先删除房间区域（以后修正）
				roomMapper.saloon(rc);
				roomMapper.kitchen(rc);
				roomMapper.toilet(rc);
				roomMapper.balcony(rc);
				roomMapper.garder(rc);
				roomMapper.terrace(rc);
				// 更新房间信息
				roomMapper.update(r);
			} else {//新增房间，需要设置后台端口管理设置信息
				r.setIsAvailable("N");
				r.setIsPromotions("N");
				r.setIsShow("N");
				r.setIsTop("N");
				r.setRadomNum(CreateRadomNum.createNum());
				roomMapper.insert(r);
			}
		}
		// 保存合同中的房屋，房间信息
		HouseData houseData = recive.getHouseData();

		//检查该房屋是否存在
		House h = houseMapper.selectByCode(houseData.getSysHouseId());
		House house = new House();
		BeanUtils.copyProperties(houseData, house);
		house.setRentNum(houseAndRoomDao.countFreeNumber(house.getSysHouseId()));
		//house.setTitle(houseTitle);
		if (h != null) {
			houseMapper.update(house);
		} else {
			house.setIsTop("N");
			house.setIsShow("N");
			house.setIsAvailable("N");
			house.setIsPromotions("N");
			houseMapper.insert(house);
		}
		System.out.print("[收房合同] " + contract.getContractCode() + "  :success!");
		System.out.println("=======================================================================");
		System.out.println();

		return "success";
	}

	/**
	 * 出房合同业务处理方法
	 * 
	 * @param outContractData
	 */
	public String synchroOutContract(ContractData outContractData) {
		// 保存客户资料信息
		CustomerData custData = outContractData.getCustomerData();
		String code = customerMapper.selectByCode(custData.getSysCustId());
		Customer customer = new Customer();
		BeanUtils.copyProperties(custData, customer);
		if (code == null) {
			customer.setCustType("KH");
			customerMapper.insert(customer);
		} else {
			customerMapper.update(customer);
		}

		// 房间信息更改
		if (outContractData.getRoomList() != null) {
			for (RoomData rd : outContractData.getRoomList()) {
				Room r = new Room();
				r.setCustSex(custData.getSex());
				r.setCustCode(custData.getCustCode());
				//BeanUtils.copyProperties(rd, r);
				r.setSysHouseId(rd.getSysHouseId());
				r.setSysRoomId(rd.getSysRoomId());
				r.setRoomStatus(rd.getRoomStatus());
				r.setRentStatus(rd.getRentStatus());
				roomMapper.update(r);
			}
		}

		// 房屋信息更改
		House h = new House();
		//BeanUtils.copyProperties(outContractData.getHouseData(), h);
		h.setRentNum(houseAndRoomDao.countFreeNumber(outContractData.getHouseData().getSysHouseId()));
		h.setHouseStatus(outContractData.getHouseData().getHouseStatus());
		h.setRentStatus(outContractData.getHouseData().getRentStatus());
		h.setSysHouseId(outContractData.getHouseData().getSysHouseId());
		houseMapper.update(h);

		// 保存合同信息
		Contract c = new Contract();
		BeanUtils.copyProperties(outContractData, c);
		Contract ct = contractMapper.selectByCode(c);
		
		if (ct != null) {
			contractMapper.update(c);
		} else {
			contractMapper.insert(c);
		}
		System.out.print("[出房合同] " + outContractData.getContractCode() + "  :success!");
		System.out.println("=======================================================================");
		System.out.println();
		
		return "success";
	}

	/**
	 * 合同解约处理
	 * 
	 * @param channelContract
	 */
	public String synchroChannelContract(ContractData channelContract) {

		// 合同处理
		Contract c = new Contract();
		BeanUtils.copyProperties(channelContract, c);
		contractMapper.update(c);
		//if (c != null) {
//		} else {
//			c = new Contract();
//			BeanUtils.copyProperties(channelContract, c);
//			contractMapper.insert(c);
		//}

		// 房间处理
		if (channelContract.getRoomList() != null) {
			for (RoomData rd : channelContract.getRoomList()) {
				Room r = new Room();
				r.setCustCode("");
				r.setCustSex("");
				//BeanUtils.copyProperties(rd, r);
				r.setSysHouseId(rd.getSysHouseId());
				r.setSysRoomId(rd.getSysRoomId());
				r.setRoomStatus(rd.getRoomStatus());
				r.setRentStatus(rd.getRentStatus());
				roomMapper.update(r);
			}
		}

		// 房屋处理
		if (channelContract.getHouseData() != null) {
			House h = new House();
			//BeanUtils.copyProperties(channelContract.getHouseData(), h);
			h.setRentNum(houseAndRoomDao.countFreeNumber(channelContract.getHouseData().getSysHouseId()));
			h.setHouseStatus(channelContract.getHouseData().getHouseStatus());
			h.setRentStatus(channelContract.getHouseData().getRentStatus());
			h.setSysHouseId(channelContract.getHouseData().getSysHouseId());
			houseMapper.update(h);
		}
		System.out.print("[合同解约] " + channelContract.getContractCode() + "  :success!");
		System.out.println("=======================================================================");
		System.out.println();
		
		return "success";
	}

	/**
	 * 合同信息更改数据同步方法
	 * 
	 * @param contractData
	 */
	public String synchroModifyContract(ContractData contractData) {
		/*
		if(contractData.getSysContractId() == null) {
			System.out.println();
			return "[Error]:合同唯一标识不存在";
		}
		if(contractData.getSysCustId() == null) {
			return "[Error]:合同客户唯一标识不存在";
		}
		if(contractData.getSysHouseId() == null) {
			return "[Error]:合同房源唯一标识不存在";
		}
		if(!StringUtils.isEmpty(contractData.getContractCode())) {
			return "[Error]:合同编号不存在";
		}
		if(!StringUtils.isEmpty(contractData.getHouseCode())) {
			return "[Error]:房源编号不存在";
		}
		if(!StringUtils.isEmpty(contractData.getCustCode())) {
			return "[Error]:客户编号不存在";
		}
		if(!StringUtils.isEmpty(contractData.getContractState())){
			return "[Error]:合同状态不存在";
		}
		*/
		Contract c = new Contract();
		BeanUtils.copyProperties(contractData, c);
//		String code = contractMapper.selectByContractCode(contractData.getSysContractId());
		contractMapper.update(c);
//		if (code != null) {
//			
//		} else {
//			//contractMapper.insert(c);
//		}
		System.out.print("[合同信息更改] " + contractData.getContractCode() + "  :success!");
		System.out.println("=======================================================================");
		System.out.println();
		
		return "success";
	}

	/**
	 * 合同作废业务处理方法
	 * 
	 * @param contractCode
	 */
	public String synchroInvalidContract(ContractData contractData) {

		// 合同处理
		Contract c = new Contract();
		BeanUtils.copyProperties(contractData, c);
		contractMapper.update(c);

		// 房间处理
		if (contractData.getRoomList() != null) {
			for (RoomData rd : contractData.getRoomList()) {
				Room r = new Room();
				r.setCustCode("");
				r.setCustSex("");
				//BeanUtils.copyProperties(rd, r);
				r.setSysHouseId(rd.getSysHouseId());
				r.setSysRoomId(rd.getSysRoomId());
				r.setRoomStatus(rd.getRoomStatus());
				r.setRentStatus(rd.getRentStatus());
				r.setFlag(rd.getFlag());
				roomMapper.update(r);
			}
		}

		// 房屋处理
		if (contractData.getHouseData() != null) {
			House h = new House();
			//BeanUtils.copyProperties(contractData.getHouseData(), h);
			h.setRentNum(houseAndRoomDao.countFreeNumber(contractData.getHouseData().getSysHouseId()));
			h.setHouseStatus(contractData.getHouseData().getHouseStatus());
			h.setRentStatus(contractData.getHouseData().getRentStatus());
			h.setSysHouseId(contractData.getHouseData().getSysHouseId());
			h.setFlag(contractData.getHouseData().getFlag());
			houseMapper.update(h);
		}
		System.out.print("[合同作废] " + contractData.getContractCode() + "  :success!");
		System.out.println("=======================================================================");
		System.out.println();
		
		return "success";
	}

	/**
	 * 新增客户资料信息同步业务处理方法
	 * 
	 * @param customerData
	 */
	public void synchroAddCustomer(CustomerData customerData) {
		synchroCustomer(customerData);
	}

	/**
	 * 修改客户资料信息同步业务处理方法
	 * 
	 * @param customerData
	 */
	public void synchroUpdateCustomer(CustomerData customerData) {
		synchroCustomer(customerData);
	}

	/**
	 * 删除客户资料信息同步业务处理方法
	 * 
	 * @param customerData
	 */
	public void synchroDelCustomer(CustomerData customerData) {
		customerMapper.deleteById(customerData.getSysCustId());
	}

	/**
	 * 客户资料信息
	 * 
	 * @param customerData
	 */
	public String synchroCustomer(CustomerData customerData) {
		/*
		if(customerData.getSysCustId() == null) {
			System.out.println("[Error]: 客户唯一标识不存在");
			return "[Error]: 客户唯一标识不存在";
		}
		if(!StringUtils.isEmpty(customerData.getCustCode())) {
			System.out.println("[Error]: 客户编号不存在");
			return "[Error]: 客户编号不存在";
		}
		*/
		String code = customerMapper.selectByCode(customerData.getSysCustId());
		Customer c = new Customer();
		BeanUtils.copyProperties(customerData, c);
		if (code != null) {
			customerMapper.update(c);
		} else {
			customerMapper.insert(c);
		}
		System.out.print("[同步客户] " + customerData.getCustCode() + "  :success!");
		System.out.println("=======================================================================");
		System.out.println();

		return "success";
	}

	public void setContractMapper(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	public void setHouseMapper(HouseMapper houseMapper) {
		this.houseMapper = houseMapper;
	}

	public void setRoomMapper(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	public void setHouseAndRoomDao(HouseAndRoomDao houseAndRoomDao) {
		this.houseAndRoomDao = houseAndRoomDao;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}