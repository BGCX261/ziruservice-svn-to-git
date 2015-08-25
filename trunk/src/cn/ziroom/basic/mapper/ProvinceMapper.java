package cn.ziroom.basic.mapper;

import cn.ziroom.basic.domain.Province;

public interface ProvinceMapper {

	int insert(Province record);

	String selectByCode(String code);

	int update(Province record);
}