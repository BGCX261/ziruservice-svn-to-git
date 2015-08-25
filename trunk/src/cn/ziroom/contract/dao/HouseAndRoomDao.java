package cn.ziroom.contract.dao;

import cn.ziroom.basic.mapper.AreaMapper;
import cn.ziroom.basic.mapper.BusinessMapper;
import cn.ziroom.basic.mapper.DictMapper;
import cn.ziroom.basic.mapper.DistrictMapper;
import cn.ziroom.basic.mapper.SubwayMapper;
import cn.ziroom.contract.data.HouseData;
import cn.ziroom.contract.mapper.RoomMapper;

/**
 * 支持网站查询信息设置 "rent_num"房屋剩余房间数量
 * 
 * @author Administrator
 * 
 */
public class HouseAndRoomDao {

	private RoomMapper roomMapper;

	private DistrictMapper districtMapper;

	private BusinessMapper businessMapper;

	private SubwayMapper subwayMapper;

	private AreaMapper areaMapper;
	
	private DictMapper dictMapper;

	/**
	 * 计算房屋空闲房间数量
	 * 
	 * @param houseCode
	 * @return
	 */
	public int countFreeNumber(Integer houseCode) {
		// 房屋总房间数
		int countRoomNum = roomMapper.countRoomNum(houseCode);
		// 房屋出租房间数量
		int outRoomNum = roomMapper.countOutRoom(houseCode);
		// 房屋预定房间数量
		int reservationRoomNum = roomMapper.countReservationRoomNum(houseCode);
		return (countRoomNum - outRoomNum - reservationRoomNum);
	}

	/**
	 * 通过房屋区县，地铁线路等信息生成房屋名称
	 * 
	 * @return
	 */
	public String createHouseTitle(HouseData house) {
		String district = districtMapper.selectByCodeReturnName(house.getCounties());
		String busion = businessMapper.selectByCodeReturnName(house.getShopping());
		String subway = subwayMapper.selectByCodeReturnName(house.getSubwayLine());
		String area = areaMapper.selectByCodeReturnName(house.getProjectcode());
		String bed = house.getDecorateBedroomNum() + "居室";
		String rtn = (district != null ? district : "") + (busion != null ? busion : "") + (subway != null ? subway : "") + (area != null ? area : "") + (bed != null ? bed : "");
		return rtn;
	}

	/**
	 * 生成房间名称
	 * 
	 * @param houseTitle
	 * @param position
	 * @return
	 */
	public String createRoomTitle(String houseTitle, String position) {
		String face = dictMapper.selectByCodeReturnName(position);
		return houseTitle + "-" + face + "卧";
	}

	public void setRoomMapper(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	public void setDistrictMapper(DistrictMapper districtMapper) {
		this.districtMapper = districtMapper;
	}

	public void setBusinessMapper(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}

	public void setSubwayMapper(SubwayMapper subwayMapper) {
		this.subwayMapper = subwayMapper;
	}

	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}

	public void setDictMapper(DictMapper dictMapper) {
		this.dictMapper = dictMapper;
	}

}
