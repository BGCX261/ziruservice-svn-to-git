package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.SubwayStation;

public interface SubwayStationMapper {
	
    int insert(SubwayStation record);

    String selectByCode(String code);

    int update(SubwayStation record);
    
    ArrayList<Object> selectAll();
}