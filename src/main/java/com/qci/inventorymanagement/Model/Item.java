package com.qci.inventorymanagement.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@Column(name = "item_title")
	private String itemtitle;
	
	//Joining the category_title
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "catelog_title")
	private Category category;
	
	//Joining the subcategory_title
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subcategory_title")
	private Subcategory subcategory;
	
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable =false)
	private Date created_date;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;
	
	
	@Column(name = "status")
	private String status="1";
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "itemid")
	private Set<ItemHistory> itemHistory = new HashSet<ItemHistory>(0);

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Item(int id, String itemtitle, Date created_date, Category category, Subcategory subcategory,
			Date updated_date, String status) {
		super();
		this.id = id;
		this.itemtitle = itemtitle;
		this.created_date = created_date;
		this.category = category;
		this.subcategory = subcategory;
		this.updated_date = updated_date;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getItemtitle() {
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


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Subcategory getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
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


	public Set<ItemHistory> getItemHistory() {
		return itemHistory;
	}


	public void setItemHistory(Set<ItemHistory> itemHistory) {
		this.itemHistory = itemHistory;
	}

	


	
	
}
