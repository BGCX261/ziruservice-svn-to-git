package cn.ziroom.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.common.util.StringUtils;
import cn.ziroom.contract.data.ContractData;
import cn.ziroom.contract.data.CustomerData;
import cn.ziroom.contract.data.HouseData;
import cn.ziroom.contract.data.RoomData;
import cn.ziroom.contract.service.ContractService;
import cn.ziroom.contract.service.RoomService;

/**
 * 同步资产业务数据的接口
 * 
 * @author Administrator
 *
 */
@WebService(name = "ziruService")
public class ZiruContractInterface {

	private ContractService contractService;

	private RoomService roomService;

	/**
	 * 接口1 收房业务数据同步方法
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	public String reciveContract(ContractData data){
		
		return contractService.synchroReciveContract(data);
	}

	/**
	 * 出房合同业务信息同步
	 * 
	 * @param outContractData
	 * @return
	 */
	@WebMethod
	public String outContract(ContractData outContractData) {
		/*
		if(outContractData.getSysCustId() == null) {
			return "出房合同中sysCustId没有唯一标识";
		}
		if(outContractData.getSysContractId() == null) {
			return "出房合同中sysContractId没有唯一标识";
		}
		if(outContractData.getSysHouseId() == null) {
			return "出房合同中sysHouseId没有唯一标识";
		}
		if(!StringUtils.isEmpty(outContractData.getCustCode())) {
			return "出房合同客户编号不存在";
		}
		if(!StringUtils.isEmpty(outContractData.getHouseCode())) {
			return "出房合同房源编号不存在";
		}
		if (!StringUtils.isEmpty(outContractData.getContractCode())) {
			return "出房合同号不存在";
		}
		if (!StringUtils.isEmpty(outContractData.getHouseCode())) {
			return "出房合同房源编号不存在";
		}
		if (!StringUtils.isEmpty(outContractData.getCustCode())) {
			return "出房合同客户编号不存在";
		}
		if(!StringUtils.isEmpty(outContractData.getCustomerData().getCustCode())) {
			return "出房合同关联的客户信息中客户编号不存在";
		}
		if(outContractData.getCustomerData().getSysCustId() == null) {
			return "出房合同关联的客户信息中客户没有唯一标识";
		}
		if(outContractData.getRoomList() != null) {
			for(RoomData rd : outContractData.getRoomList()) {
				if(rd.getSysRoomId() == null) {
					return "出房合同关联的房间没有房间唯一标识";
				}
				if(!StringUtils.isEmpty(rd.getRoomCode())) {
					return "出房合同关联的房间中房间编号不存在";
				}
				if(!StringUtils.isEmpty(rd.getRentStatus())) {
					return "出房合同关联的房间中房源出租状态不存在";
				}
			}
		}
		if(outContractData.getHouseData().getSysHouseId()==null) {
			return "出房合同关联的房屋中唯一标识不存在";
		}
		*/
		return contractService.synchroOutContract(outContractData);
	}

	/**
	 * 合同违约，到期处理
	 * 
	 * @param channelContract
	 * @return
	 */
	@WebMethod
	public String channContract(ContractData channelContract) {
		/*
		if(channelContract.getSysContractId() == null) {
			return "合同唯一标识不存在";
		}
		if(!StringUtils.isEmpty(channelContract.getContractCode())) {
			return "合同编号不存在";
		}
		if(!StringUtils.isEmpty(channelContract.getContractState())) {
			return "合同状态不存在";
		}
		if(channelContract.getHouseData() != null) {	
			if(channelContract.getHouseData().getSysHouseId() == null) {
				return "合同编号关联房屋属性中房源唯一标识不存在";
			}
			if(!StringUtils.isEmpty(channelContract.getHouseData().getHouseCode())) {
				return "合同编号关联房屋属性房源编号不存在";
			}
		}
		if(channelContract.getRoomList() != null) {
			for(RoomData rd : channelContract.getRoomList()) {
				if(rd.getSysRoomId() == null) {
					return "合同编号关联房间属性中房间唯一标识不存在";
				}
				if(!StringUtils.isEmpty(rd.getRoomCode())) {
					return "合同编号关联房间属性房间编号不存在";
				}
			}
		}
		*/
		return contractService.synchroChannelContract(channelContract);
	}

	/**
	 * 房屋或房间预订业务处理
	 * 
	 * @param houseCode
	 * @param roomCode
	 * @return
	 */
	@WebMethod
	public String reservation(HouseData houseData) {
		/*
		if(houseData.getSysHouseId() == null) {
			return "房屋唯一标识不存在";
		}
		if(!StringUtils.isEmpty(houseData.getHouseCode())) {
			return "房屋编号不存在";
		}
		if(!StringUtils.isEmpty(houseData.getRentStatus())) {
			return "房屋出租状态不存在";
		}
		if (houseData.getRoomData() != null) {
			for(RoomData rd : houseData.getRoomData()){	
				if(rd.getSysRoomId() == null) {
					return "房屋关联房间属性中房间唯一标识不存在";
				}
				if(!StringUtils.isEmpty(rd.getRoomCode())) {
					return "房间编号不存在";
				}
				if(!StringUtils.isEmpty(rd.getRentStatus())) {
					return "房间出租状态不存在";
				}
			}
		}
		*/
		return roomService.synchroReservation(houseData);
	}

	/**
	 * 合同作废业务数据同步
	 * 
	 * @param contractCode
	 * @return
	 */
	@WebMethod
	public String invalidContract(ContractData contractData) {
		/*
		if(contractData.getSysContractId() == null) {
			return "合同编号中唯一标识不存在";
		}
		if(!StringUtils.isEmpty(contractData.getContractCode())) {
			return "合同编号不存在";
		}
		if(!StringUtils.isEmpty(contractData.getContractState())) {
			return "合同状态不存在";
		}
		// 房屋处理
		if(contractData.getHouseData() != null) {	
			if(contractData.getHouseData().getSysHouseId() == null) {
				return "合同关联房屋的房源没有唯一标识";
			}
			if(!StringUtils.isEmpty(contractData.getHouseData().getHouseCode())) {
				return "合同关联房屋的房源编号不存在";
			}
		}
		//房间处理
		if(contractData.getRoomList() != null) {
			for(RoomData rd : contractData.getRoomList()) {
				if(rd.getSysRoomId() == null) {
					return "合同关联房间的房间没有唯一标识";
				}
				if(!StringUtils.isEmpty(rd.getRoomCode())) {
					return "合同关联房间的房间编号不存在";
				}
			}
		}
		*/
		return contractService.synchroInvalidContract(contractData);
	}

	/**
	 * 合同信息的数据同步
	 * 
	 * @param contractData
	 * @return
	 */
	@WebMethod
	public String modifyContract(ContractData contractData) {
		
		return contractService.synchroModifyContract(contractData);
	}

	/**
	 * 房屋信息同步处理方法
	 * 
	 * @param houseData
	 * @return
	 */
	@WebMethod
	public String house(HouseData houseData) {
		
		return roomService.synchroHouse(houseData);
	}

	/**
	 * 房间信息同步
	 * 
	 * @param roomData
	 * @return
	 */
	@WebMethod
	public String room(RoomData roomData) {
		
		return roomService.synchroRoom(roomData);
	}

	/**
	 * 房间图片信息同步
	 * 
	 * @param roomData
	 * @return
	 */
	@WebMethod
	public String roomPictures(RoomData roomData) {
		
		return roomService.synchroRoomPictures(roomData);
	}

	/**
	 * 删除房间图片信息
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String delRoomRegion(Integer sysRoomId, String key, Integer sysHouseId) {
		
		return roomService.synchroDelRoomRegion(sysRoomId, key, sysHouseId);
	}

	/**
	 * 客户资料信息同步
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String customer(CustomerData customerData) {
		
		return contractService.synchroCustomer(customerData);
	}
	
	/**
	 * 房间物品信息同步
	 * 
	 * @param roomData
	 * @return
	 */
	@WebMethod
	public String roomConfigItem(RoomData roomData) {
		
		return roomService.synchroRoomConfig(roomData);
	}


	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
}
