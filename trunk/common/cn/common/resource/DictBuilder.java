package cn.common.resource;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.common.util.Batis2Map;
import cn.common.util.StringUtils;
import cn.ziroom.basic.mapper.DictMapper;
import cn.ziroom.contract.validate.ValidateException;

import com.google.gson.Gson;

/**
 * 数据字典的信息
 * 
 * @author manguo
 * 
 */
public class DictBuilder {

	private static DictBuilder instance = new DictBuilder();

	public final static String DICT_KEY = "DICT_KEY";

	public static String HOUSE_PRODUCT = "HOUSE_PRODUCT";		//房源产品
	public static String PROPERTY_TYPE = "PROPERTY_TYPE";		//物业类型
	public static String HOUSE_FACE = "HOUSE_FACE";				//房屋朝向
	public static String HEATING_TYPE = "HEATING_TYPE";			//供暖类型
	public static String FLOOR_MATERIAL = "FLOOR_MATERIAL";		//地板材料
	public static String GAS_STOVE_TYPE = "GAS_STOVE_TYPE";		//煤气管道类型
	public static String GAS_INTERFACE_TYPE = "GAS_INTERFACE_TYPE";//煤气接入方式
	public static String WINDOW_FACE = "WINDOW_FACE";			//窗户朝向
	public static String IS_CUT = "IS_CUT";						//是否隔断间
	public static String HAVE_WINDOW = "HAVE_WINDOW";			//是否有窗户
	public static String HAVE_CURTAIN = "HAVE_CURTAIN";			//是否有窗帘
	public static String HAVE_FAN = "HAVE_FAN";					//是否有风扇
	public static String GARDEN_TYPE = "GARDEN_TYPE";			//花园类型
	public static String IS_NATURAL_SOIL = "IS_NATURAL_SOIL";	//是否天然泥土
	public static String LEASE_YEAR = "LEASE_YEAR";				//出租年限
	public static String PAY_TYPE = "PAY_TYPE";					//付款类型
	public static String FEE_TYPE = "FEE_TYPE";					//收费类型
	public static String FEE_OPERATOR_TYPE = "FEE_OPERATOR_TYPE";	//支付方式
	public static String CUSTOMER_SOURCE = "CUSTOMER_SOURCE";	//客户来源
	public static String CUSTOMER_TYPE = "CUSTOMER_TYPE";		//客户类型
	public static String INTEREST_TYPE = "INTEREST_TYPE";		//兴趣类型
	public static String HOUSE_STATUS = "HOUSE_STATUS";			//房屋状态
	public static String ROOM_STATUS = "ROOM_STATUS";			//房间状态
	public static String CONTRACT_STATUS = "CONTRACT_STATUS";	//合同状态
	public static String REGION_TYPE = "REGION_TYPE";			//功能区域的类型
	public static String RENT_TYPE = "RENT_TYPE";				//出租类型
	public static String CONTRACT_TYPE = "CONTRACT_TYPE";		//合同类型， 收房合同，出房合同
	public static String BUILDING_TYPE = "BUILDING_TYPE";		//建筑类型
	public static String ROOM_TYPE = "ROOM_TYPE";				//房间类型
	public static String ROOM_TYPE_ITEM = "ROOM_TYPE_ITEM";		//房间功能区域的简称
	
	private static HashMap<String, LinkedHashMap<String, String>> dict = new HashMap<String, LinkedHashMap<String, String>>();;

	/**
	 * 私有构造方法， 用来实现单例
	 */
	private DictBuilder() {
		System.out.println("constract a DictBuilder instance!");
	}

	public static void refresh(ServletContext application) {

		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);// 获取spring的context
		DictMapper dictMapper = (DictMapper) wac.getBean("dictMapper");
		dict = Batis2Map.toDict(dictMapper.selectAll());
	}

	public static void stat() {
		System.out.println("DictBuilder : " + dict.toString());
	}

	/**
	 * 清除字典信息缓存中的所有数据
	 */
	public static void clear() {
		dict.clear();
		System.out.println("clear the DictBuilder Object......finish.");
	}

	/**
	 * 获取字典管理器的实例
	 * 
	 * @return
	 */
	public static DictBuilder getInstance() {
		if (instance == null) {
			instance = new DictBuilder();
		}

		return instance;
	}

	/**
	 * 通过数据字典获取指定编码的值
	 * 
	 * @param type
	 * @param code
	 * @return
	 */
	public static String getValue(String type, String code) {
		return dict.get(type).get(code);
	}

	/**
	 * 转换json数据
	 * 
	 * @param type
	 * @return
	 */
	public static String getJson(String type) {
		LinkedHashMap<String, String> map = dict.get(type);
		Gson g = new Gson();
		return g.toJson(map);
	}

	/**
	 * 通过数据字典检查是否存在相应的code值
	 * 
	 * @param type
	 * @param code
	 * @return
	 */
	public static boolean containsKey(String type, String code) {
		return dict.get(type).containsKey(code);
	}

	/**
	 * 通过数据字典检查是否存在相应的Value值
	 * 
	 * @param type
	 * @param value
	 * @return
	 */
	public static boolean containsValue(String type, String value) {
		return dict.get(type).containsValue(value);
	}
	
	/**
	 * 检验数据字典中存在指定的编码？
	 * 
	 * @param type
	 * @param code
	 * @throws ValidateException
	 */
	public static void validateCode(String type, String code) throws ValidateException{
		if(!StringUtils.isEmpty(code)){
			throw new ValidateException(type+"不能为空！");
		}
		if(!dict.get(type).containsKey(code)){
			throw new ValidateException(type+"编码不存在！");
		}
	}
	
	
	//==============================================以下都是验证方法======================================
	
}
