package com.qci.inventorymanagement.alterEntity;

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
@Table(name="item_history")
public class AlterItemhistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "itemid")
	private  int itemid;
	
	@Column(name = "add_taken")
	private int add_taken;
	
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable =false)
	private Date created_date;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;
	
	@Column(name = "price")
	private int price ;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "remain")
	private int remain;
	
	@Column(name = "total_price")
	private int total_price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getAdd_taken() {
		return add_taken;
	}

	public int setAdd_taken(int add_taken) {
		return this.add_taken = add_taken;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public AlterItemhistory(int id, int itemid, int add_taken, Date created_date, Date updated_date, int price,
			int quantity, int remain, int total_price) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.add_taken = add_taken;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.price = price;
		this.quantity = quantity;
		this.remain = remain;
		this.total_price = total_price;
	}
	
	public AlterItemhistory() {
		
	}
}
