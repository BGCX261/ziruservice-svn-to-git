package cn.ziroom.house.mapper;

import java.util.List;
import java.util.Map;

import cn.ziroom.contract.domain.RoomPictures;
import cn.ziroom.house.domain.House;
import cn.ziroom.house.domain.Room;
import cn.ziroom.system.domain.User;

/**
 * 房屋，房间，房间照片，配置物品数据房屋接口
 * 
 * @author Administrator
 * 
 */
public interface HouseAndRoomMapper {

	List<House> searchHouseList(House house);

	int countHouse(House house);

	List<Room> searchRoomByHouseCode(Integer sysHouseId);

	House selectHouseByCode(Integer sysHouseId);

	void updateHouse(House house);

	void updateRoomByHouseCode(Room room);

	Room selectRoomByCode(Integer sysRoomId);

	void updateRoom(Room room);

	int countPubRoom(Room room);

	int countRoom(Integer sysHouseId);

	int countTopRoomNum(Integer sysHouseId);

	int countPromotionsRoomNum(Integer sysHouseId);

	House selectHouse(Integer sysHouseId);

	List<User> selectByFirst(User param);

	List<User> selectBySecond(User param);

	List<User> selectByThird(User param);

	User selectByStaff(User user);

	int countPromotions(String code);

	int countTop(String code);

	Room selectByRoomId(Integer roomId);

	List<RoomPictures> selectRoomPicturesByRoomId(Integer sysRoomId);
	
	List<RoomPictures> selectRoomPicturesByHouseId(Integer sysHouseId);
	
	@SuppressWarnings("rawtypes")
	List<String> selectItemByRoom(Map map);
	
	@SuppressWarnings("rawtypes")
	List<String> selectItemByPub(Map map);
	
	@SuppressWarnings("rawtypes")
	List<Map> selectOtherRoom(Map map);
	
}