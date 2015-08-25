package cn.ziroom.system.mapper;

import cn.ziroom.system.domain.Function;
import java.util.List;

public interface FunctionMapper {
    int count(Function example);

    int deleteById(Integer functionId);

    int insert(Function record);

    List<Function> selectList();

    Function selectById(Integer functionId);

    int update(Function record);
    
    List<Function> selectNodeList(Integer functionId);
}