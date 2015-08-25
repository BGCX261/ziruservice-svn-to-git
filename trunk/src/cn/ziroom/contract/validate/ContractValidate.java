package cn.ziroom.contract.validate;

import cn.common.resource.DictBuilder;
import cn.common.util.StringUtils;
import cn.ziroom.contract.data.ContractData;

/**
 * 用来校验合同实体信息
 * 
 * @author manguo
 */
public class ContractValidate {

	/**
	 * 验证收房合同中的数据有效性
	 * 
	 * @param contract
	 * @throws ValidateException
	 */
	public static void validate(ContractData contract) throws ValidateException{
		
		if(contract.getSysContractId() == null) {
			throw new ValidateException( "收房合同不存在合同唯一标识");
		}
		if(contract.getSysHouseId() == null) {
			throw new ValidateException(  "收房合同不存在房屋唯一标识");
		}
		if(contract.getSysCustId() == null) {
			throw new ValidateException(  "收房合同不存在客户唯一标识");
		}
		if (!StringUtils.isEmpty(contract.getCustCode())) {
			throw new ValidateException(  "收房合同客户编号不存在");
		}
		if (!StringUtils.isEmpty(contract.getContractCode())) {
			throw new ValidateException(  "收房合同号不存在");
		}
		if (!StringUtils.isEmpty(contract.getHouseCode())) {
			throw new ValidateException(  "收房合同房源编号不存在");
		}
		if (!StringUtils.isEmpty(contract.getCustCode())) {
			throw new ValidateException(  "收房合同客户编号不存在");
		}
		if (!StringUtils.isEmpty(contract.getCustomerData().getCustCode())) {
			throw new ValidateException(  "收房合同关联客户信息中客户编号不存在");
		}
		if (contract.getCustomerData().getSysCustId() == null) {
			throw new ValidateException(  "收房合同关联客户信息中客户没有唯一标识");
		}
		
		//验证合同状态
		DictBuilder.validateCode(DictBuilder.CONTRACT_STATUS, contract.getContractState());
		
		//验证房屋属性
		HouseValidate.validate(contract.getHouseData());
		
		//验证房间属性
		RoomValidate.validateList(contract.getRoomList());
		
	}
}
