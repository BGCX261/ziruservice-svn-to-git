package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.City;

public interface CityMapper {
	
	String selectByCode(String code);

	ArrayList<Object> selectAll();
	
	int insert(City record);

	int update(City record);
}