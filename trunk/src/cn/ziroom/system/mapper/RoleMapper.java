package cn.ziroom.system.mapper;

import cn.ziroom.system.domain.Role;
import java.util.List;

public interface RoleMapper {
    int count(Role example);

    int deleteById(Integer roleId);

    int insert(Role record);

    List<Role> selectList(Role example);

    Role selectById(Integer roleId);

    int update(Role record);
    
    Role selectByName(String roleName);
    
}