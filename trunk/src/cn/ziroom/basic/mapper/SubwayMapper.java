package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.Subway;

public interface SubwayMapper {
	
	int insert(Subway record);

	String selectByCode(Subway example);
	
	String selectByCodeReturnName(String code);

	int update(Subway record);
	
	ArrayList<Object> selectAll();
}