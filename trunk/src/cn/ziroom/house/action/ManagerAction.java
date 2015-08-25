package cn.ziroom.house.action;

import cn.common.action.GeneralAction;
import cn.common.util.GeneralUtils;
import cn.ziroom.contract.mapper.ConfigMapper;
import cn.ziroom.contract.mapper.ContractMapper;
import cn.ziroom.contract.mapper.CustomerMapper;
import cn.ziroom.contract.mapper.RoomPicturesMapper;

public class ManagerAction extends GeneralAction {

	private static final long serialVersionUID = 4452358354871464900L;

	private ContractMapper contractMapper;

	private CustomerMapper customerMapper;

	private ConfigMapper configMapper;

	private RoomPicturesMapper roomPicturesMapper;

	public void contract() throws Exception {
		String json = GeneralUtils.easyUI(contractMapper.selectList(null));
		out(json);
	}

	public void customer() throws Exception {
		String json = GeneralUtils.easyUI(customerMapper.selectList(null));
		out(json);
	}

	public void roomPictures() throws Exception {
		String json = GeneralUtils.easyUI(roomPicturesMapper.selectList(null));
		out(json);
	}

	public void config() throws Exception {
		String json = GeneralUtils.easyUI(configMapper.selectList(null));
		out(json);
	}

	public void setContractMapper(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	public void setConfigMapper(ConfigMapper configMapper) {
		this.configMapper = configMapper;
	}

	public void setRoomPicturesMapper(RoomPicturesMapper roomPicturesMapper) {
		this.roomPicturesMapper = roomPicturesMapper;
	}
}
