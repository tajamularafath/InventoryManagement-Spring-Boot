package com.qci.inventorymanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qci.inventorymanagement.JoinEntity.CategorySubcategoryJoin;
import com.qci.inventorymanagement.Model.Subcategory;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, Integer>{

	@Query("select new com.qci.inventorymanagement.JoinEntity.CategorySubcategoryJoin (b.id, b.subcategory_title, a.title,b.created_date, b.updated_date, b.status)from Subcategory b inner join Category a on b.category = a.id")
//	@Query("select new com.qci.inventorymanagement.JoinEntity.CategorySubcategoryJoin (b.id,b.subcategoryTitle,a.category, b.created_date, b.updated_date, b.status)from Subcategory b inner join Category a on b.category = a.id") 

	public List<CategorySubcategoryJoin> join();
}
