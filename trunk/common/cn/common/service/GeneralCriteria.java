package cn.common.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 扩展类
 * 
 * @author 孙树林
 * 
 */
public abstract class GeneralCriteria implements Serializable {

	private static final long serialVersionUID = -5773330983879986510L;

	protected List<GeneratedCriteria> oredCriteria = new ArrayList<GeneratedCriteria>();

	/** distinct */
	protected boolean distinct;
	/** 排序 */
	protected String orderByClause;

	protected String json;

	protected int line;

	protected int currentPage = 0;

	protected Integer page = 1;

	protected int totalLine;

	protected String selectedFirst;

	protected String selectedSecond;

	protected String code;
	/**  */
	protected Integer aut_cust_id;

	public List<GeneratedCriteria> getOredCriteria() {
		return oredCriteria;
	}

	public void setOredCriteria(List<GeneratedCriteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	public void invoke() {
		Iterator<GeneratedCriteria> it = oredCriteria.iterator();
		while (it.hasNext()) {
			Iterator<Criterion> ite = it.next().getCriteria().iterator();
			while (ite.hasNext()) {
				Criterion criterion = ite.next();
				criterion.createCondition();
			}
		}
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getTotalLine() {
		return totalLine;
	}

	public void setTotalLine(int totalLine) {
		this.totalLine = totalLine;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSelectedFirst() {
		return selectedFirst;
	}

	public void setSelectedFirst(String selectedFirst) {
		this.selectedFirst = selectedFirst;
	}

	public String getSelectedSecond() {
		return selectedSecond;
	}

	public void setSelectedSecond(String selectedSecond) {
		this.selectedSecond = selectedSecond;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getAut_cust_id() {
		return aut_cust_id;
	}

	public void setAut_cust_id(Integer aut_cust_id) {
		this.aut_cust_id = aut_cust_id;
	}
}
