package cn.ziroom.contract.mapper;

import cn.ziroom.contract.domain.RoomPictures;
import java.util.List;

public interface RoomPicturesMapper {
	
    int count(RoomPictures example);

    int deleteById(Integer hpimageid);
    
    int deleteByRoomCode(RoomPictures example);

    int insert(RoomPictures record);

    List<RoomPictures> selectList(RoomPictures example);

    RoomPictures selectById(Integer hpimageid);

    int update(RoomPictures record);
    
    int updateFlag(List<String> imageCode);
}