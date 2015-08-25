package cn.ziroom.contract.validate;

import java.util.List;

import cn.common.resource.DictBuilder;
import cn.common.util.StringUtils;
import cn.ziroom.contract.data.RegionData;

public class RegionValidate {

	/**
	 * 验证单个功能区域
	 * 
	 * @param region
	 * @throws ValidateException
	 */
	public static void validate(RegionData region) throws ValidateException{
		if(!StringUtils.isEmpty(region.getRegionType())){
			throw new ValidateException("该功能区域的类型不能为空");
		}else if( !DictBuilder.containsKey(DictBuilder.REGION_TYPE, region.getRegionType())){
			throw new ValidateException( "收房合同房间扩展区域类型regionType没有填写,且房间扩展区域类型只能包括saloon,kitchen,toliet,balcony,garder,terrace");
		}else{
			//do nothing
		}
	}
	
	/**
	 * 验证功能区域的列表
	 * @param list
	 * @throws ValidateException
	 */
	public static void validateList(List<RegionData> list) throws ValidateException{
		if (list != null) {
			for (RegionData region : list) {
				validate(region);
			}
		}
	}
}
