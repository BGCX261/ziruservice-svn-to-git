package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.Cycle;

public interface CycleMapper {

	int insert(Cycle record);

	String selectByCode(String code);
	
	ArrayList<Object> selectAll();

	int update(Cycle record);
}