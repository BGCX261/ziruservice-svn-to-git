package cn.ziroom.contract.mapper;

import cn.ziroom.contract.domain.Contract;
import java.util.List;

public interface ContractMapper {

	int count(Contract example);

	int deleteById(Integer id);

	int insert(Contract record);

	List<Contract> selectList(Contract example);

	Contract selectById(Integer id);
	
	Contract selectByCode(Contract example);

	int update(Contract record);
	
	String selectByContractCode(Integer sysContractId);
}