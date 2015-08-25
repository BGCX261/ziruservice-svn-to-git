package cn.ziroom.basic.service;

import java.util.List;

import cn.ziroom.basic.domain.Business;
import cn.ziroom.basic.domain.City;
import cn.ziroom.basic.domain.District;
import cn.ziroom.basic.domain.DistrictBusiness;
import cn.ziroom.basic.domain.Province;
import cn.ziroom.basic.mapper.BusinessMapper;
import cn.ziroom.basic.mapper.CityMapper;
import cn.ziroom.basic.mapper.DistrictBusinessMapper;
import cn.ziroom.basic.mapper.DistrictMapper;
import cn.ziroom.basic.mapper.ProvinceMapper;

/**
 * 商圈业务处理类
 * 
 * @author Administrator
 * 
 */
public class TradingAreaService {
	
	
	/** 城市数据访问接口 */
	private CityMapper cityMapper;
	/** 商圈数据访问接口 */
	private BusinessMapper businessMapper;
	/** 城区与商圈数据访问接口 */
	private DistrictBusinessMapper districtBusinessMapper;
	/** 省，直辖市，自治区数据访问接口 */
	private ProvinceMapper provinceMapper;
	/** 城区数据访问接口 */
	private DistrictMapper districtMapper;

	/**
	 * 同步城市列表信息业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroCity(List<City> list) {
		try{
			for (City city : list) {
				String code = cityMapper.selectByCode(city.getCityCode());
				if (code != null) {
					cityMapper.update(city);
				} else {
					cityMapper.insert(city);
				}
			}
			return "success";
		}catch(Exception e){
			return "false";
		}
	}

	/**
	 * 同步城区列表业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroDistrict(List<District> list) {
		for (District district : list) {
			String code = districtMapper.selectByCode(district.getDistrictCode());
			if (code != null) {
				districtMapper.update(district);
			} else {
				districtMapper.insert(district);
			}
		}
		return "success";
	}

	/**
	 * 同步商圈列表信息业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroBusiness(List<Business> list) {
		for (Business business : list) {
			String code = businessMapper.selectByCode(business.getBusinessCode());
			if (code != null) {
				businessMapper.update(business);
			} else {
				businessMapper.insert(business);
			}
		}
		return "success";
	}

	/**
	 * 同步城区与商圈的关系业务处理方法
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	public String synchroDistBusin(List<DistrictBusiness> list, String operator) {
		for (DistrictBusiness districtBusiness : list) {
			if (operator.equals("D")) {
				districtBusinessMapper.deleteByCode(districtBusiness);
			} else {
				String code = districtBusinessMapper.selectByCode(districtBusiness);
				if (code == null) {
					districtBusinessMapper.insert(districtBusiness);
				}
			}
		}
		return "success";
	}

	/**
	 * 同步省，直辖市，自治区信息业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroProvince(List<Province> list) {
		for (Province province : list) {
			String code = provinceMapper.selectByCode(province.getProvinceCode());
			if (code != null) {
				provinceMapper.update(province);
			} else {
				provinceMapper.insert(province);
			}
		}
		return "success";
	}

	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	public void setBusinessMapper(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}

	public void setDistrictBusinessMapper(DistrictBusinessMapper districtBusinessMapper) {
		this.districtBusinessMapper = districtBusinessMapper;
	}

	public void setProvinceMapper(ProvinceMapper provinceMapper) {
		this.provinceMapper = provinceMapper;
	}

	public void setDistrictMapper(DistrictMapper districtMapper) {
		this.districtMapper = districtMapper;
	}
}