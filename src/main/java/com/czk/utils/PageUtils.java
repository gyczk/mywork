package com.czk.utils;

import java.util.List;

public class PageUtils<T> {
	
	public PageUtils() {
		super();
	}


	private int limit;
	private int offset;
	
	private int total;
	private List<T> rows;
	
	
	public PageUtils(int total,List<T> rows){
		this.total = total;
		this.rows = rows;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public List<T> getRows() {
		return rows;
	}


	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
