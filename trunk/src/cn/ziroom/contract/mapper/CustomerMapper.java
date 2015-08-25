package cn.ziroom.contract.mapper;

import cn.ziroom.contract.domain.Customer;
import java.util.List;

public interface CustomerMapper {

	int count(Customer example);

	int deleteById(Integer id);

	int insert(Customer record);

	List<Customer> selectList(Customer example);

	Customer selectById(Integer id);

	int update(Customer record);
	
	String selectByCode(Integer sysCustId);
}