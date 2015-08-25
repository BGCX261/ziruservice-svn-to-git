package cn.common.resource;

public final class ResourceFactory {

	/**
	 * 私有的构造方法
	 */
	private ResourceFactory() {

	}

	/**
	 * 获取楼盘字典的相关资源信息
	 * 
	 * @return
	 */
	public static ResourceBuilder getResourceBuilder() {

		return ResourceBuilder.getInstance();
	}
}
