package cn.ziroom.contract.mapper;

import cn.ziroom.contract.domain.House;
import java.util.List;

public interface HouseMapper {
    int count(House example);

    int deleteById(Integer houseId);

    int insert(House record);

    List<House> selectList(House example);

    House selectById(Integer houseId);
    
    House selectByCode(Integer sysHouseId);

    int update(House record);
}