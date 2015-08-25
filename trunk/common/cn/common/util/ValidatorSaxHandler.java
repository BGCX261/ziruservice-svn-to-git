package cn.common.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 解析xxx*-validator.XML文件
 * 
 * @author 孙树林
 * 
 */
public class ValidatorSaxHandler {

	/** 解析后保存在Map中 */
	@SuppressWarnings("rawtypes")
	private Map saxMaps = new HashMap();

	/** DOCMENT文档 */
	private Document document;

	public ValidatorSaxHandler(File filePath) throws DocumentException {
		super();
		SAXReader reader = new SAXReader();
		reader.setValidation(false);
		reader.setIncludeInternalDTDDeclarations(false);
		reader.setIncludeExternalDTDDeclarations(false);
		reader.setEntityResolver(new NoDtdEntityResolver());
		document = reader.read(filePath);
	}

	/**
	 * 获得validator.xml根元素
	 * 
	 * @return
	 */
	public Element getRoot() {
		return document.getRootElement();
	}

	/**
	 * 解析文件
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void parser() {
		// 获得field元素集合
		List fieldElements = getRoot().elements("field");
		int size = fieldElements.size();
		for (int i = 0; i < size; i++) {
			Element fieldElement = (Element) fieldElements.get(i);
			String name = fieldElement.attributeValue("name");
			Map map = new HashMap();
			saxMaps.put(name, map);
			addFieldValidator(map, fieldElement);
		}
	}

	/**
	 * 获得field元素下的field-validator元素集合
	 * 
	 * @param map
	 * @param fieldElement
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addFieldValidator(Map map, Element fieldElement) {
		List fieldValidatorElements = fieldElement.elements("field-validator");
		int size = fieldValidatorElements.size();
		for (int i = 0; i < size; i++) {
			Element fieldValidatorElement = (Element) fieldValidatorElements.get(i);
			String type = fieldValidatorElement.attributeValue("type");
			Map _map = new HashMap();
			map.put(type, _map);
			addParamAndMsg(_map, fieldValidatorElement);
		}
	}

	/**
	 * 加入参数及提示信息
	 * 
	 * @param map
	 * @param fieldValidatorElement
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addParamAndMsg(Map map, Element fieldValidatorElement) {
		List params = fieldValidatorElement.elements("param");
		int size = params.size();
		for (int i = 0; i < size; i++) {
			Element param = (Element) params.get(i);
			String name = param.attributeValue("name");
			String text = param.getTextTrim();
			map.put(name, text);
		}
		Element msg = fieldValidatorElement.element("message");
		map.put("msg", msg.getTextTrim());
	}

	@SuppressWarnings("rawtypes")
	public Map getSaxMaps() {
		return saxMaps;
	}

	/**
	 * 定义使用验证DTD
	 * 
	 * @author 孙树林
	 * 
	 */
	private class NoDtdEntityResolver implements EntityResolver {

		/**
		 * @param arg0
		 * @param arg1
		 * @return
		 * @throws SAXException
		 * @throws IOException
		 *             作者：孙树林 创建日期:2011-1-11
		 */
		@Override
		public InputSource resolveEntity(String arg0, String arg1) throws SAXException, IOException {
			URL url = NoDtdEntityResolver.class.getClassLoader().getResource("xwork-validator-1.0.2.dtd");
			return new InputSource(url.getPath());
		}

	}
}
