package com.qci.inventorymanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qci.inventorymanagement.Model.Category;
import com.qci.inventorymanagement.Repository.CatalogRepo;

@Service
public class CatalogService {

	@Autowired
	private CatalogRepo catalogrepo;
	
	
	public List<Category> getCatalog(){
		return catalogrepo.findAll();
	}
	
	public Category savecatalog(Category category) {
		return catalogrepo.save(category);
	}

	public Category getCatalogId(Integer id) {

		Optional<Category> optional = catalogrepo.findById(id);
		Category category = null;
		
		if(optional.isPresent()) {
			category=optional.get();
		}
		else {
			System.out.println("Item not found:"+id);
		}
		return category;
	
	}
	
//	public Category findSingleId(Integer id) {
//		return catalogrepo.findById(id).orElse(null);
//	}
	
	public Category updatecata(Category category ) {

		Category cataCategory = catalogrepo.findById(category.getId()).orElse(null);
		cataCategory.setTitle(category.getTitle());
		cataCategory.setStatus(category.getStatus());
		cataCategory.setUpdated_date(category.getUpdated_date());
		
		return catalogrepo.save(category);
	}

	
	public void deleteCatalog(Integer id) {
		catalogrepo.deleteById(id);
	}
}