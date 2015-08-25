package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.SubStation;

public interface SubStationMapper {

	int deleteByCode(SubStation example);

	int insert(SubStation record);

	String selectByCode(SubStation example);
	
	ArrayList<Object> selectAll();
}