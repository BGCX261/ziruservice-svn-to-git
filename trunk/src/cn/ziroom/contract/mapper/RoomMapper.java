package cn.ziroom.contract.mapper;

import cn.ziroom.contract.domain.Room;
import java.util.List;

public interface RoomMapper {
	int count(Room example);

	int countRoom(Integer sysHouseId);

	int countOutRoom(Integer sysHouseId);

	int countRoomNum(Integer sysHouseId);

	int countReservationRoomNum(Integer sysHouseId);

	int deleteById(Integer sysRoomId);

	int insert(Room record);

	List<Room> selectList(Room example);

	Room selectById(Integer roomId);

	Room selectByCode(Room room);

	int update(Room record);

	int updateByHouseCode(Room code);

	int updateFlag(Room record);

	int saloon(Room example);

	int kitchen(Room example);

	int toilet(Room example);

	int balcony(Room example);
	
	int garder(Room example);
	
	int terrace(Room example);
}