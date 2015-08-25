package cn.ziroom.system.mapper;

import java.util.List;

import cn.ziroom.system.domain.User;

public interface UserMapper {

	int insert(User record);

	String selectByCode(String code);

	int update(User record);
	
	User selectByAccount(User user);
	
	List<User> selectList(User user);
	
	int count(User record);
	
	User selectById(Integer id);
	
	int updateUser(User user);
	
	User searchUserByStaffId(String staffid);
}