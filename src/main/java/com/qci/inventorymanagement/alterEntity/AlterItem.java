package com.qci.inventorymanagement.alterEntity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class AlterItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "item_title")
	private String itemtitle;
	
	@CreationTimestamp
	@Column(name = "creaded_date", nullable = false, updatable = false)
	private Date creaded_date;
	
	@UpdateTimestamp
	@Column(name ="updated_date")
	private Date updated_date;
	
	@Column(name = "catelog_title")
	private String category;
	
	@Column(name = "subcategory_title")
	private String subcategory;
	
	@Column(name = "status")
	private String status;

	public AlterItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlterItem(int id, String itemtitle, Date creaded_date, Date updated_date, String category,
			String subcategory, String status) {
		super();
		this.id = id;
		this.itemtitle = itemtitle;
		this.creaded_date = creaded_date;
		this.updated_date = updated_date;
		this.category = category;
		this.subcategory = subcategory;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_title() {
		return itemtitle;
	}

	public void setItemtitle(String itemtitle) {
		this.itemtitle = itemtitle;
	}

	public Date getCreaded_date() {
		return creaded_date;
	}

	public void setCreaded_date(Date creaded_date) {
		this.creaded_date = creaded_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}


