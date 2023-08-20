package com.qci.inventorymanagement.JoinEntity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class CategorySubcategoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "item_title")
	private String itemtitle;
	
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable =false)
	private Date created_date;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;
	
	@Column(name = "category_id")
	private String category;
	
	@Column(name = "subcategory_id")
	private String subcategory;
	
	@Column(name = "status")
	private String status;

	public CategorySubcategoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorySubcategoryItem(int id, String itemtitle, Date created_date, Date updated_date, String status,
			String category, String subcategory) {
		super();
		this.id = id;
		this.itemtitle = itemtitle;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.status = status;
		this.category = category;
		this.subcategory = subcategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemTitle() {
		return itemtitle;
	}

	public void setItemtitle(String itemtitle) {
		this.itemtitle = itemtitle;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
