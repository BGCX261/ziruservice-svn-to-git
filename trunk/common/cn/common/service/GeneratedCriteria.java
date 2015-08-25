package cn.common.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = -8799928962588637558L;

	private List<Criterion> criteria = new ArrayList<Criterion>();

	public boolean isValid() {
		return criteria.size() > 0;
	}

	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}
}
