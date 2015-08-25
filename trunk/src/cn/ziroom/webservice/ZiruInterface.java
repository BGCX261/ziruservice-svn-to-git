package cn.ziroom.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.ziroom.basic.domain.Area;
import cn.ziroom.basic.domain.Business;
import cn.ziroom.basic.domain.City;
import cn.ziroom.basic.domain.Cycle;
import cn.ziroom.basic.domain.CycleFace;
import cn.ziroom.basic.domain.District;
import cn.ziroom.basic.domain.DistrictBusiness;
import cn.ziroom.basic.domain.Province;
import cn.ziroom.basic.domain.SubStation;
import cn.ziroom.basic.domain.Subway;
import cn.ziroom.basic.domain.SubwayStation;
import cn.ziroom.basic.service.AreaService;
import cn.ziroom.basic.service.CycleService;
import cn.ziroom.basic.service.SubwayService;
import cn.ziroom.basic.service.TradingAreaService;

/**
 * ziru外部访问接口定义,同步楼盘字典信息的接口
 * 
 * @author Administrator
 * 
 */
@WebService(serviceName = "ziruInterface")
public class ZiruInterface {

	private TradingAreaService tradingAreaService;

	private SubwayService subwayService;
	
	private CycleService cycleService;
	
	private AreaService areaService;

	/**
	 * 城市同步接口
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroCity(List<City> list) {
		return tradingAreaService.synchroCity(list);
	}

	/**
	 * 同步城区的接口
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroDistrict(List<District> list) {
		return tradingAreaService.synchroDistrict(list);
	}

	/**
	 * 同步商圈的接口
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroBusiness(List<Business> list) {
		return tradingAreaService.synchroBusiness(list);
	}

	/**
	 * 同步城区和商圈的关联关系的接口
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroDistBusin(List<DistrictBusiness> list, String operator) {
		return tradingAreaService.synchroDistBusin(list, operator);
	}

	/**
	 * 同步省份的接口
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroProvince(List<Province> list) {
		return tradingAreaService.synchroProvince(list);
	}

	/**
	 * 同步地铁站点的接口
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroSubStation(List<SubStation> list, String operator) {
		return subwayService.synchroSubStation(list, operator);
	}
	
	/**
	 * 同步地铁线路的接口
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String synchroSubway(List<Subway> list) {
		return subwayService.synchroSubway(list);
	}
	
	/**
	 * 同步地铁站点和地铁线路的关联关系的接口
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String synchroSubwayStation(List<SubwayStation> list) {
		return subwayService.synchroSubwayStation(list);
	}
	
	/**
	 * 同步环线的接口
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String synchroCycle(List<Cycle> list) {
		return cycleService.synchroCycle(list);
	}
	
	/**
	 * 同步朝向的接口
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String synchroCycleFace(List<CycleFace> list) {
		return cycleService.synchroCycleFace(list);
	}
	
	/**
	 * 同步小区的接口
	 * 
	 * @param list
	 * @return
	 */
	@WebMethod
	public String synchroArea(List<Area> list) {
		return areaService.synchroArea(list);
	}
	
	
	/**====================================一下是set方法====================================*/
	public void setTradingAreaService(TradingAreaService tradingAreaService) {
		this.tradingAreaService = tradingAreaService;
	}

	public void setSubwayService(SubwayService subwayService) {
		this.subwayService = subwayService;
	}

	public void setCycleService(CycleService cycleService) {
		this.cycleService = cycleService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
}
