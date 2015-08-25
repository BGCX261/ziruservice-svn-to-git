package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.Business;

public interface BusinessMapper {

	int insert(Business record);

	String selectByCode(String code);
	
	String selectByCodeReturnName(String code);
	
	ArrayList<Object> selectAll();

	int update(Business record);
}