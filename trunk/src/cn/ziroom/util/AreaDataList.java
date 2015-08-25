package cn.ziroom.util;

import java.util.ArrayList;
import java.util.Iterator;

import cn.ziroom.basic.domain.AreaData;

public class AreaDataList extends ArrayList<AreaData> {

	private static final long serialVersionUID = 8782373218311441281L;

	@Override
	public boolean remove(Object o) {
		if(o == null) {
			return false;
		}
		AreaData d = (AreaData) o;
		Iterator<AreaData> it = this.iterator();
		int i = 0;
		while (it.hasNext()) {
			AreaData a = (AreaData) it.next();
			if(d.getCode() != null && !d.getCode().equals("") && a.getCode().equals(d.getCode())) {
				super.remove(a);
				break;
			}
			i++;
		}
		return false;
	}

	@Override
	public boolean add(AreaData e) {
		boolean isExist = false;
		if(e != null) {
			AreaData d = (AreaData) e;
			Iterator<AreaData> it = this.iterator();
			while (it.hasNext()) {
				AreaData a = (AreaData) it.next();
				if(d.getCode() != null && !d.getCode().equals("") && a.getCode().equals(d.getCode())) {
					isExist = true;
				}
			}
		}
		if(isExist) {
			return false;
		} else {
			return super.add(e);
		}
	}

	public void update(Object o) {
		if(o != null) {
			AreaData d = (AreaData) o;
			Iterator<AreaData> it = this.iterator();
			while (it.hasNext()) {
				AreaData a = (AreaData) it.next();
				if(d.getCode() != null && !d.getCode().equals("") && a.getCode().equals(d.getCode())) {
					a.setLatitude(d.getLatitude());
					a.setLongitude(d.getLongitude());
					a.setName(d.getName());
				}
			}
		}
	}
}
