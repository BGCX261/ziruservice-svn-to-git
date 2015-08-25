package cn.common.resource;

import java.util.LinkedHashMap;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.common.util.Batis2Map;
import cn.common.util.StringUtils;
import cn.ziroom.basic.mapper.BusinessMapper;
import cn.ziroom.basic.mapper.CityMapper;
import cn.ziroom.basic.mapper.CycleFaceMapper;
import cn.ziroom.basic.mapper.CycleMapper;
import cn.ziroom.basic.mapper.DistrictMapper;
import cn.ziroom.basic.mapper.SubwayMapper;
import cn.ziroom.basic.mapper.SubwayStationMapper;
import cn.ziroom.contract.validate.ValidateException;

import com.google.gson.Gson;

/**
 * 初始化资源类的工具
 * 
 * @author Administrator
 *
 */
public class ResourceBuilder {

	private static ResourceBuilder instance = new ResourceBuilder();
	
	public static final String RESOURCE_KEY = "RESOURCE_KEY";
	
	public static final int SUBWAY = 1;		//地铁线路
	public static final int STATION = 2;	//站点
	public static final int CITY = 3;		//城市
	public static final int DISTRICT = 4;	//区域
	public static final int BUSINESS = 5;	//商圈
	public static final int CYCLE = 6;		//环线
	public static final int FACE = 7;		//朝向
	
	private static  LinkedHashMap<String,String> subway;  
	private static  LinkedHashMap<String,String> station;  
	private static  LinkedHashMap<String,String> city;  
	private static  LinkedHashMap<String,String> district;  
	private static  LinkedHashMap<String,String> business ;  
	private static  LinkedHashMap<String,String> cycle;  
	private static  LinkedHashMap<String,String> face;  
	
	private ResourceBuilder(){
		subway = new LinkedHashMap<String,String>();  
		station = new LinkedHashMap<String,String>();  
		city = new LinkedHashMap<String,String>();  
		district = new LinkedHashMap<String,String>();  
		business = new LinkedHashMap<String,String>();  
		cycle = new LinkedHashMap<String,String>();  
		face = new LinkedHashMap<String,String>();
	}
	
	/**
	 * 获取资源的实例
	 * 
	 * @return
	 */
	public static ResourceBuilder getInstance(){
		if(instance == null){
			
			instance = new ResourceBuilder();
		}
		return instance;
	}
	
	/**
	 * 将所有的资源类型的数据全部清空掉
	 * 存储所有数据信息的HashMap都是以<code, value>的方式来保存数据的。
	 */
	public static void clear(){
		subway.clear();  
		station.clear();  
		city.clear();  
		district.clear();  
		business.clear();  
		cycle.clear();  
		face.clear();
		System.out.println("clear the ResourceBuilder Object......finish.");
	}
	
	/**
	 * 重新初始化相关的资源类信息
	 */
	public static void refresh(ServletContext application){
		 WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);//获取spring的context
		 SubwayMapper subwayMapper = (SubwayMapper)wac.getBean("subwayMapper");
		 subway = Batis2Map.toMap(subwayMapper.selectAll(), "subwayCode", "subwayName");
		 
		 SubwayStationMapper stationMapper = (SubwayStationMapper)wac.getBean("subwayStationMapper");
		 station = Batis2Map.toMap(stationMapper.selectAll(), "stationCode", "stationName");
		 
		 CityMapper cityMapper = (CityMapper)wac.getBean("cityMapper");
		 city = Batis2Map.toMap(cityMapper.selectAll(), "cityCode", "cityName");
		 
		 DistrictMapper districtMapper = (DistrictMapper)wac.getBean("districtMapper");
		 district = Batis2Map.toMap(districtMapper.selectAll(), "districtCode", "districtName");
		
		 BusinessMapper businessMapper = (BusinessMapper)wac.getBean("businessMapper");
		 business = Batis2Map.toMap(businessMapper.selectAll(), "businessCode", "businessName");
		 
		 CycleMapper cycleMapper = (CycleMapper)wac.getBean("cycleMapper");
		 cycle = Batis2Map.toMap(cycleMapper.selectAll(), "cycleCode", "cycleName");
		 
		CycleFaceMapper faceMapper = (CycleFaceMapper)wac.getBean("cycleFaceMapper");
		face = Batis2Map.toMap(faceMapper.selectAll(), "faceCode", "faceName");

		System.out.println("initial the ResourceBuilder Object......finish.");
	}
	
	/**
	 * 分析当前资源中的存储状态
	 * 
	 */
	public static void stat(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nsubway    :" + subway);  
		buffer.append("\nstation   :" + station); 
		buffer.append("\ncity      :" + city); 
		buffer.append("\ndistrict  :" + district);  
		buffer.append("\nbusiness  :" + business);  
		buffer.append("\ncycle     :" + cycle); 
		buffer.append("\nface      :" + face); 
		System.out.println(" stat the ReourceBuilder info ........" + buffer.toString());
	}
	
	/**
	 * 检查是否在缓存中存在相关的楼盘字典信息
	 * 
	 * @param type
	 * @param code
	 * @return
	 */
	public static boolean checkCode(int type, String code){
		boolean flag = false;
		
		if(StringUtils.isEmpty(code)){
			return flag;
		}
		
		switch(type){
		
		case SUBWAY:
			flag = subway.containsKey(code);
			break;
		case STATION:
			flag = station.containsKey(code);
			break;
		case CITY:
			flag = city.containsKey(code);
			break;
		case DISTRICT:
			flag = district.containsKey(code);
			break;
		case BUSINESS:
			flag = business.containsKey(code);
			break;
		case CYCLE:
			flag = cycle.containsKey(code);
			break;
		case FACE:
			flag = face.containsKey(code);
			break;
		}
		
		return flag ;
	}
	
	/**
	 * 验证编码是否不为空，请切存在
	 * @param type
	 * @param code
	 */
	public static void validateCode(int type, String code) throws ValidateException{
		
		switch(type){
		
		case SUBWAY:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("地铁线路不能为空！");
			}
			if(!subway.containsKey(code)){
				throw new ValidateException("地铁线路编号不正确！");
			}
			break;
		case STATION:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("地铁站点不能为空！");
			}
			if(!station.containsKey(code)){
				throw new ValidateException("地铁编号不正确！");
			}
			break;
		case CITY:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("城市不能为空！");
			}
			if(!city.containsKey(code)){
				throw new ValidateException("城市编号不正确！");
			}
			break;
		case DISTRICT:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("地区不能为空！");
			}
			if(!district.containsKey(code)){
				throw new ValidateException("地区编号不正确！");
			}
			break;
		case BUSINESS:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("商圈不能为空！");
			}
			if(!business.containsKey(code)){
				throw new ValidateException("商圈编号不正确！");
			}
			break;
		case CYCLE:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("环线不能为空！");
			}
			if(!cycle.containsKey(code)){
				throw new ValidateException("环线编号不正确！");
			}
			break;
		case FACE:
			if(!StringUtils.isEmpty(code)){
				throw new ValidateException("环线朝向不能为空！");
			}
			if(!face.containsKey(code)){
				throw new ValidateException("环线朝向编号不正确！");
			}
			break;
		}
		
	}
	
	/**
	 * 检验缓存中是否存在相应的值
	 * @param type
	 * @param value
	 * @return
	 */
	public static boolean checkValue(int type, String value){
		boolean flag = false;
		
		switch(type){
		
		case SUBWAY:
			flag = subway.containsValue(value);
			break;
		case STATION:
			flag = station.containsValue(value);
			break;
		case CITY:
			flag = city.containsValue(value);
			break;
		case DISTRICT:
			flag = district.containsValue(value);
			break;
		case BUSINESS:
			flag = business.containsValue(value);
			break;
		case CYCLE:
			flag = cycle.containsValue(value);
			break;
		case FACE:
			flag = face.containsValue(value);
			break;
		}
		
		return flag ;
	}
	
	/**
	 * 获取字典值
	 * 
	 * @param type
	 * @param code
	 * @return
	 */
	public static String getValue(int type, String code){
		
		String ret = "";
		
		switch(type){
		
		case SUBWAY:
			ret= subway.get(code);
			break;
		case STATION:
			ret = station.get(code);
			break;
		case CITY:
			ret =  city.get(code);
			break;
		case DISTRICT:
			ret =  district.get(code);
			break;
		case BUSINESS:
			ret =  business.get(code);
			break;
		case CYCLE:
			ret =  cycle.get(code);
			break;
		case FACE:
			ret =  face.get(code);
			break;
		}
		return ret;
	}
	
	/**
	 * 获取字典值
	 * 
	 * @param type
	 * @param code
	 * @return
	 */
	public static String getValue(int type){
		
		String ret = "";
		Gson gson = new Gson();
		switch(type){
		
		case SUBWAY:
			ret= gson.toJson(subway);
			break;
		case STATION:
			ret = gson.toJson(station);
			break;
		case CITY:
			ret =  gson.toJson(city);
			break;
		case DISTRICT:
			ret =  gson.toJson(district);
			break;
		case BUSINESS:
			ret =  gson.toJson(business);
			break;
		case CYCLE:
			ret =  gson.toJson(cycle);
			break;
		case FACE:
			ret =  gson.toJson(face);
			break;
		}
		return ret;
	}
	
	//==============================================以下都是验证方法======================================
	/**
	 * 验证地铁线路是否为空，是否存在数据字典中。
	 * @param code
	 */
	public static void validateSubway(String code) throws ValidateException{
		if( StringUtils.isNull(code) || !subway.containsKey(code)){
			
			throw new ValidateException("subway 不能为空或者不包含在字典信息中！" + code );
		}
	}
	
	/**
	 * 验证地铁站点
	 */
	public static void validateSubwayStation(String code)  throws ValidateException{
		if(StringUtils.isNull(code) || !station.containsKey(code)){
			throw new ValidateException("subway station 不能为空或者不包含在字典信息中！" + code);
		}
	}
}
