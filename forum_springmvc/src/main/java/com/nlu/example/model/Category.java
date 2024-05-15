package com.nlu.example.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String title;
	private Category parent;
	private List<Category> children = new ArrayList<Category>();

	public Category(String title) {
		this.title = title;
	}

	public Category(String title, Category parent) {
		this.title = title;
		if (parent != null) {
			this.parent = parent;
			parent.addChild(this);
		}
	}

	public String getTitle() {
		return title;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	protected void addChild(Category child) {
		this.getChildren().add(child);
	}
}
