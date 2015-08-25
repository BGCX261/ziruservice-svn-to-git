package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.District;

public interface DistrictMapper {

    int insert(District record);

    String selectByCode(String code);
    
    String selectByCodeReturnName(String code);
    
    ArrayList<Object> selectAll();

    int update(District record);
}