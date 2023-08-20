package com.qci.inventorymanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qci.inventorymanagement.JoinEntity.CategorySubcategoryItem;
import com.qci.inventorymanagement.Model.Item;
@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

//	@Query("select new com.qci.inventorymanagement.JoinEntity.CategorySubcategoryItem( a.id, a.itemTitle, a.created_date,a.updated_date,b.category,c.subcategory,a.status)from Item a inner join Category b on a.category = b.id inner join Subcategory c on a.subcategory = b.id")
	@Query("select new com.qci.inventorymanagement.JoinEntity.CategorySubcategoryItem(a.id, a.itemtitle, a.created_date,a.updated_date,b.title,c.subcategory_title,a.status) from Item a inner join Category b on a.category = b.id inner join Subcategory c on a.subcategory = b.id")
	public List<CategorySubcategoryItem>join();
}
