package cn.ziroom.contract.validate;

import cn.ziroom.contract.data.ConfigData;
import cn.ziroom.contract.data.RoomData;

/**
 * 验证房间配置物品的有效性
 * 
 * @author manguo
 *
 */
public class ConfigValidate {
	
	public static void validate(RoomData rd) throws ValidateException{
		
		if(rd.getSysRoomId() == null) {
			throw new ValidateException( "房间唯一标识不存在");
		}
		for (ConfigData cd : rd.getConfigList()) {
			if(cd.getSysRoomId() == null) {
				throw new ValidateException( "房间关联物品信息中没有房间唯一标识");
			}
		}
	}
}
