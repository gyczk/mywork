package com.czk.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query extends LinkedHashMap<String,Object>{
	private int limit;//每页条数
	private int offset;//第几页
	
	
	public Query(Map<String,Object> params){
		this.putAll(params);
		this.limit = Integer.parseInt(params.get("limit").toString());
		this.offset = Integer.parseInt(params.get("offset").toString());
		this.put("offset", offset);
		this.put("page", offset / limit + 1);
		this.put("limit", limit);
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
	
}
