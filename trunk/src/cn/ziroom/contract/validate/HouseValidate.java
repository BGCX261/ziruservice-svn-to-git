package cn.ziroom.contract.validate;

import cn.common.resource.DictBuilder;
import cn.common.resource.ResourceBuilder;
import cn.common.util.StringUtils;
import cn.ziroom.contract.data.HouseData;

/**
 * 验证房屋的接口数据信息
 * 
 * @author manguo
 *
 */
public class HouseValidate {

	/**
	 * 验证单套房屋的关键信息
	 * @param house
	 * @throws ValidateException
	 */
	public static void validate(HouseData house) throws ValidateException{
		if (StringUtils.isNull(house.getSysHouseId()) ) {
			throw new ValidateException( "收房合同关联的房屋没有唯一标识");
		}
		if (StringUtils.isNull(house.getSysContractId())) {
			throw new ValidateException( "收房合同关联的房屋没有收房合同唯一标识");
		}
		if (!StringUtils.isEmpty(house.getHouseCode())) {
			throw new ValidateException( "收房合同关联的房屋信息房屋编号不存在");
		}
		if(!StringUtils.isEmpty(house.getTitle())){
			throw new ValidateException("房屋的名称不能为空！");
		}
		if(!StringUtils.isEmpty(house.getDictHouseCode())){
			throw new ValidateException("13位的房屋编号不能为空！");
		}
		
		//验证环线编码是否为空， 是否存在。
		ResourceBuilder.validateCode(ResourceBuilder.CYCLE, house.getCycle());
		
		//验证环线朝向是否为空，编码是否存在
		ResourceBuilder.validateCode(ResourceBuilder.FACE, house.getCycleFace());
		
		//验证区域是否为空， 编码是否存在
		ResourceBuilder.validateCode(ResourceBuilder.DISTRICT, house.getCounties());
		
		//验证商圈
		ResourceBuilder.validateCode(ResourceBuilder.BUSINESS, house.getShopping());
		
		//验证地铁线路
		ResourceBuilder.validateCode(ResourceBuilder.SUBWAY, house.getSubwayLine());
		
		//验证地铁站点
		ResourceBuilder.validateCode(ResourceBuilder.STATION, house.getSubwayStations());
		
		//验证小区编号
		if(!StringUtils.isEmpty(house.getProjectcode())){
			throw new ValidateException("小区编号不能为空！");
		}
		
		//建筑类型
		DictBuilder.validateCode(DictBuilder.BUILDING_TYPE, house.getBuildType());
		
		
		//房屋朝向
		DictBuilder.validateCode(DictBuilder.HOUSE_FACE, house.getHouseFace());
		
		//供暖方式
		DictBuilder.validateCode(DictBuilder.HEATING_TYPE, house.getHeating());
		
		//出租类型
		DictBuilder.validateCode(DictBuilder.RENT_TYPE, house.getRentType());
		
		//房屋产品
		DictBuilder.validateCode(DictBuilder.HOUSE_PRODUCT, house.getHouseProduct());
		
		//房屋状态
		DictBuilder.validateCode(DictBuilder.HOUSE_STATUS, house.getHouseStatus());
	}
}
