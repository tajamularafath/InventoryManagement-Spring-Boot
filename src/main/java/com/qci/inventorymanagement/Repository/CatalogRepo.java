package com.qci.inventorymanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qci.inventorymanagement.Model.Category;
@Repository
public interface CatalogRepo extends JpaRepository<Category, Integer> {

}
