package com.czk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tree<T> implements Serializable{
	private Long id;
	private String text;
	private Map<String, Object> state;
	private boolean checked = false;
	private Map<String,Object> attributes;
	private List<Tree<T>> children = new ArrayList<>();
	/**
	 * 父ID
	 */
	private Long parentId;
	/**
	 * 是否有父节点
	 */
	private boolean hasParent = false;
	private boolean hasChildren = false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Map<String, Object> getState() {
		return state;
	}

	public void setState(Map<String, Object> state) {
		this.state = state;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<Tree<T>> getChildren() {
		return children;
	}
	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public boolean isHasParent() {
		return hasParent;
	}
	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}
	public void setChildren(boolean isChildren) {
		this.hasChildren = isChildren;
	}
	
}
