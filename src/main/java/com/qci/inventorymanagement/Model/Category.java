package com.qci.inventorymanagement.Model;

import jakarta.persistence.CascadeType;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title",nullable = false)
	private String title;
	
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable =false)
	private Date created_date;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;

	@Column(name = "status",nullable = false)
	private String status = "active" ;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Subcategory> subcategory = new HashSet<Subcategory>(0);
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Item> item = new HashSet<Item>(0);
	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String title, Date created_date, Date updated_date, String status) {
		super();
		this.id = id;
		this.title = title;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	
	
	
}
