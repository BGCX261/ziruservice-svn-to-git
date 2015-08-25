package cn.ziroom.contract.mapper;

import cn.ziroom.contract.domain.Config;
import java.util.List;

public interface ConfigMapper {
    int count(Config example);

    int deleteById(Integer id);

    int insert(Config record);

    List<Config> selectList(Config example);

    Config selectById(Integer id);
    
    String selectByCode(Config example);

    int update(Config record);
    
    void deleteByRoomCode(Integer sysRoomId);
}