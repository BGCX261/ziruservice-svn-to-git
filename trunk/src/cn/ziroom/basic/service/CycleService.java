package cn.ziroom.basic.service;

import java.util.List;

import cn.ziroom.basic.domain.Cycle;
import cn.ziroom.basic.domain.CycleFace;
import cn.ziroom.basic.mapper.CycleFaceMapper;
import cn.ziroom.basic.mapper.CycleMapper;

/**
 * 环线、方位业务处理类
 * 
 * @author Administrator
 * 
 */
public class CycleService {

	/** 环线数据访问接口 */
	private CycleMapper cycleMapper;
	/** 方位数据访问接口 */
	private CycleFaceMapper cycleFaceMapper;
	
	/**
	 * 环线同步数据业务处理方法
	 * @param list
	 * @param operator
	 * @return
	 */
	public String synchroCycle(List<Cycle> list) {
		for (Cycle cycle : list) {
			String code = cycleMapper.selectByCode(cycle.getCycleCode());
			if (code != null) {
				cycleMapper.update(cycle);
			} else {
				cycleMapper.insert(cycle);
			}
		}
		return "success";
	}
	
	public String synchroCycleFace(List<CycleFace> list) {
		for (CycleFace cycleFace : list) {
			String code = cycleFaceMapper.selectByCode(cycleFace.getFaceCode());
			if (code != null) {
				cycleFaceMapper.update(cycleFace);
			} else {
				cycleFaceMapper.insert(cycleFace);
			}
		}
		return "success";
	}

	public void setCycleMapper(CycleMapper cycleMapper) {
		this.cycleMapper = cycleMapper;
	}

	public void setCycleFaceMapper(CycleFaceMapper cycleFaceMapper) {
		this.cycleFaceMapper = cycleFaceMapper;
	}
}
