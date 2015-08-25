package cn.ziroom.basic.mapper;

import cn.ziroom.basic.domain.Area;

public interface AreaMapper {

	int insert(Area record);

	Area selectByCode(String projectcode);
	
	String selectByCodeReturnName(String projectcode);

	int update(Area record);
}