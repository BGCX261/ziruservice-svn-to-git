package cn.ziroom.basic.service;

import java.util.List;

import cn.ziroom.basic.domain.SubStation;
import cn.ziroom.basic.domain.Subway;
import cn.ziroom.basic.domain.SubwayStation;
import cn.ziroom.basic.mapper.SubStationMapper;
import cn.ziroom.basic.mapper.SubwayMapper;
import cn.ziroom.basic.mapper.SubwayStationMapper;

/**
 * 地铁线路，地铁站点，地铁线路与地铁站点同步处理业务类
 * 
 * @author Administrator
 * 
 */
public class SubwayService {

	/** 地铁线路与地铁站点关系数据访问接口 */
	private SubStationMapper subStationMapper;
	/** 地铁线路数据访问接口 */
	private SubwayMapper subwayMapper;
	/** 地铁站点数据访问接口 */
	private SubwayStationMapper subwayStationMapper;

	/**
	 * 地铁线路与地铁站点同步业务处理方法
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	public String synchroSubStation(List<SubStation> list, String operator) {
		for (SubStation substation : list) {
			if (operator.equals("D")) {
				subStationMapper.deleteByCode(substation);
			} else {
				String code = subStationMapper.selectByCode(substation);
				if (code == null) {
					subStationMapper.insert(substation);
				}
			}
		}
		return "sucess";
	}

	/**
	 * 地铁线路同步业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroSubway(List<Subway> list) {
		for (Subway subway : list) {
			String code = subwayMapper.selectByCode(subway);
			if (code != null) {
				subwayMapper.update(subway);
			} else {
				subwayMapper.insert(subway);
			}
		}
		return "sucess";
	}

	/**
	 * 地铁站点同步业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroSubwayStation(List<SubwayStation> list) {
		for (SubwayStation subwayStation : list) {
			String code = subwayStationMapper.selectByCode(subwayStation.getStationCode());
			if (code != null) {
				subwayStationMapper.update(subwayStation);
			} else {
				subwayStationMapper.insert(subwayStation);
			}
		}
		return "sucess";
	}

	public void setSubStationMapper(SubStationMapper subStationMapper) {
		this.subStationMapper = subStationMapper;
	}

	public void setSubwayMapper(SubwayMapper subwayMapper) {
		this.subwayMapper = subwayMapper;
	}

	public void setSubwayStationMapper(SubwayStationMapper subwayStationMapper) {
		this.subwayStationMapper = subwayStationMapper;
	}
}
