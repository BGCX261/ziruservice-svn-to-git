package cn.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import cn.ziroom.basic.domain.Dict;
import cn.ziroom.basic.domain.Subway;

/**
 * 由于在Mybatis中没有将key， value转换成为一个Hashmap返回的功能， 所以这里这里通过返回Mybatis的数据， 重新组装成为HashMap返回，
 * 以及包含一些MyBatis的一些辅助方法
 * 
 * @author Administrator
 *
 */
public class Batis2Map {

	/**
	 * 读取所有的相关信息，然后根据所需要的对象类型，创建成有序的键值对
	 * @param list
	 * @param clz
	 * @param key
	 * @param value
	 * @return
	 */
	public static LinkedHashMap<String,String> toMap(List<Object> list, String keyAttr, String valueAttr){
		if(list != null){
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			for(Object obj : list){
				try{
					String keyMethodName = "get" + keyAttr.substring(0,1).toUpperCase() + keyAttr.substring(1);
					String valueMethodName = "get" + valueAttr.substring(0,1).toUpperCase() + valueAttr.substring(1);
					Method keyMethod = obj.getClass().getMethod(keyMethodName, new Class[] {});
					Method valueMethod = obj.getClass().getMethod(valueMethodName, new Class[]{});
					String key = (String)keyMethod.invoke(obj, new Object[] {});
					String value = (String)valueMethod.invoke(obj, new Object[]{});
					map.put(key, value);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return map;
		}else{
			return new LinkedHashMap<String,String>();
		}
	}
	
	/**
	 * 将所有的数据字典信息检索出来之后， 分类存放。
	 * 
	 * @param list
	 * @return
	 */
	public static HashMap<String, LinkedHashMap<String,String>> toDict(ArrayList<Dict> list){
		if(list != null){
			HashMap<String, LinkedHashMap<String,String>> map = new HashMap<String,LinkedHashMap<String,String>>();
			
			for(Dict dict : list){
				if(map.containsKey(dict.getdType())){//包含了相应的类型的数据字典
					map.get(dict.getdType()).put(dict.getdCode(), dict.getdValue());
				}else{//不包含相应类型
					LinkedHashMap<String, String> keyValue = new LinkedHashMap<String, String>();
					keyValue.put(dict.getdCode(), dict.getdValue());
					map.put(dict.getdType(), keyValue);
				}
			}
			
			return map;
		}else{
			return new HashMap<String,LinkedHashMap<String,String>>();
		}
	}
	
	public static void main(String[] args) throws Exception {

		List<Object> list = new ArrayList<Object>();
		
		Subway sub1 = new Subway();
		sub1.setSubwayCode("010");
		sub1.setSubwayName("ssdfad1");
		Subway sub2 = new Subway();
		sub2.setSubwayCode("012");
		sub2.setSubwayName("ssdfad2");
		
		Subway sub3 = new Subway();
		sub3.setSubwayCode("013");
		sub3.setSubwayName("ssdfad3");
		Subway sub4 = new Subway();
		sub4.setSubwayCode("014");
		sub4.setSubwayName("ssdfad4");
		Subway sub5 = new Subway();
		sub5.setSubwayCode("011");
		sub5.setSubwayName("ssdfad5");
		
		list.add(sub1);
		list.add(sub2);
		list.add(sub3);
		list.add(sub4);
		list.add(sub5);
		
		LinkedHashMap<String, String> map = Batis2Map.toMap(list,"subwayCode","subwayName");
		System.out.println(map);
	}
}
