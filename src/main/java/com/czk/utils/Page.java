package com.czk.utils;

import java.util.List;

public class Page<T> {
    public Page(){
    	
    }
    private List<T> rows;
	private int total;
	
	private int page;
	private int size;
	private int totalPages;
	
	
    public int getTotalPages() {
		return total/size;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Page(int total, int page, int size, List<T> rows) {
		super();
		this.total = total;
		this.page = page;
		this.size = size;
		this.rows = rows;
	}
    
	
    
}
