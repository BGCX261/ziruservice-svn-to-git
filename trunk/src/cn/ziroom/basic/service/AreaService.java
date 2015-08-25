package cn.ziroom.basic.service;

import java.util.List;

import cn.ziroom.basic.domain.Area;
import cn.ziroom.basic.domain.AreaData;
import cn.ziroom.basic.mapper.AreaMapper;
import cn.ziroom.util.AreaDataList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 小区业务处理类
 * 
 * @author Administrator
 * 
 */
public class AreaService {

	/** 小区数据访问接口 */
	private AreaMapper areaMapper;

	/**
	 * 同步小区信息业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroArea(List<Area> list) {
		for (Area area : list) {
			Area other = areaMapper.selectByCode(area.getProjectcode());
			boolean isOperator = false;
			if (other != null) {
				isOperator = true;
			} else {
				isOperator = false;
			}
			// 金融数据处理
			area.setRoadtransit(handler(other != null ? other.getRoadtransit() : null, area.getRoadtransitList()));
			// 公园数据处理
			area.setPark(handler(other != null ? other.getPark() : null, area.getParkList()));
			// 医院数据处理
			area.setHospital(handler(other != null ? other.getHospital() : null, area.getHospitalList()));
			// 超市数据处理
			area.setSupermarket(handler(other != null ? other.getSupermarket() : null, area.getSupermarketList()));
			// 市场数据处理
			area.setMarket(handler(other != null ? other.getMarket() : null, area.getMarketList()));
			// 娱乐数据处理
			area.setEntertainment(handler(other != null ? other.getEntertainment() : null, area.getEntertainmentList()));
			// 地铁站点数据处理
			area.setSubwaystation(handler(other != null ? other.getSubwaystation() : null, area.getSubwaystationList()));
			// 公交站点数据处理
			area.setStationName(handler(other != null ? other.getStationName() : null, area.getStationNameList()));
			if (isOperator) {
				areaMapper.update(area);
			} else {
				areaMapper.insert(area);
			}
		}
		return "success";
	}

	/**
	 * 金融，公园等处理
	 * 
	 * @param other
	 * @param area
	 */
	public String handler(String json, List<AreaData> dataList) {
		Gson gson = new Gson();
		AreaDataList list = new AreaDataList();
		if (json != null && !json.equals("")) {
			java.lang.reflect.Type type = new TypeToken<AreaDataList>() {
			}.getType();
			list = gson.fromJson(json, type);
		}
		for (AreaData data : dataList) {
			if (data.getOperation().equals("I")) {
				list.add(data);
			} else if (data.getOperation().equals("U")) {
				list.update(data);
			} else if (data.getOperation().equals("D")) {
				list.remove(data);
			}
		}
		if (list != null && list.size() > 0) {
			return gson.toJson(list);
		} else {
			return "";
		}
	}

	public static void main(String[] args) {
		AreaService service = new AreaService();
		AreaDataList list = new AreaDataList();
		list.add(new AreaData("I", "公园1", 160.444F, 39.888F, "01"));
		list.add(new AreaData("I", "公园2", 160.444F, 39.888F, "02"));
		list.add(new AreaData("I", "公园3", 160.444F, 39.888F, "03"));
		Gson gson = new Gson();
		String json = gson.toJson(list);
		AreaDataList dataList = new AreaDataList();
		dataList.add(new AreaData("D", "公园1", 160.444F, 39.888F, "01"));
		dataList.add(new AreaData("U", "公园5", 160.444F, 39.888F, "02"));
		System.out.println(service.handler(json, dataList));
	}

	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}
}