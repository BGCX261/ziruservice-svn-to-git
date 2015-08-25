package cn.ziroom.basic.mapper;

import cn.ziroom.basic.domain.DistrictBusiness;

public interface DistrictBusinessMapper {

	int deleteByCode(DistrictBusiness record);

	int insert(DistrictBusiness record);

	String selectByCode(DistrictBusiness record);

}