package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.CycleFace;

public interface CycleFaceMapper {

	int insert(CycleFace record);

	String selectByCode(String code);
	ArrayList<Object> selectAll();

	int update(CycleFace record);
}