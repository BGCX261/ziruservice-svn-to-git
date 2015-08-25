package cn.ziroom.basic.mapper;

import java.util.ArrayList;

import cn.ziroom.basic.domain.Dict;

/**
 * 字典的接口
 * 
 * @author manguo
 *
 */
public interface DictMapper {

	Dict selectByName(String type, String name);
	
	ArrayList<Dict> selectByType(String type);
	
	ArrayList<Dict> selectAll();
	
	String selectByCodeReturnName(String code);
}
