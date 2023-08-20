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
@Table(name="subcategory")
public class AlterSubcategory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "subcategory_title")
	private String subcategory_title;
	
	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date created_date;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;
	
	@Column(name = "category")
	private int category;
	
//	@Column(name = "subcategory_id")
//	private String subcategory;
	
	@Column(name = "status")
	private String status="1";

	public AlterSubcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlterSubcategory(int id, String subcategory_title, Date created_date, Date updated_date, int category,
			String status) {
		super();
		this.id = id;
		this.subcategory_title = subcategory_title;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.category = category;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubcategory_title() {
		return subcategory_title;
	}

	public void setSubcategory_title(String subcategory_title) {
		this.subcategory_title = subcategory_title;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
