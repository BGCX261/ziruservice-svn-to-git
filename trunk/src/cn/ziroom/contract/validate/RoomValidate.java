package cn.ziroom.contract.validate;

import java.util.List;

import cn.common.util.StringUtils;
import cn.ziroom.contract.data.RegionData;
import cn.ziroom.contract.data.RoomData;

public class RoomValidate {

	/**
	 * 验证单个房间信息
	 * 
	 * @param rd
	 * @throws ValidateException
	 */
	public static void validate(RoomData rd) throws ValidateException{
		if(rd.getSysHouseId() == null) {
			throw new ValidateException( "收房合同关联的房间中没有房屋唯一标识");
		}
		if(rd.getSysRoomId() == null) {
			throw new ValidateException( "收房合同关联的房间中没有房间唯一标识");
		}
		if(!"kitchen".equalsIgnoreCase(rd.getRoomType())) {
			if (!StringUtils.isEmpty(rd.getHouseCode())) {
				throw new ValidateException( "收房合同关联房间房屋编号不存在");
			}
			if (!StringUtils.isEmpty(rd.getRoomCode())) {
				throw new ValidateException( "收房合同关联房间的房间编号不存在");
			}
			//DictBuilder.validateCode(DictBuilder.ROOM_STATUS, rd.getRoomStatus());
		}
		
		List<RegionData> regionDataList = rd.getRegionDataList();
		//添加了验证功能区域的代码
		RegionValidate.validateList(regionDataList);
	}
	
	/**
	 * 验证多个房间的列表
	 * @param list
	 * @throws ValidateException
	 */
	public static void validateList(List<RoomData> list) throws ValidateException{
		for (RoomData rd : list) {
			validate(rd);
		}
	}
}
