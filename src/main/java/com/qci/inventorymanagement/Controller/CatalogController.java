package com.qci.inventorymanagement.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qci.inventorymanagement.Model.Category;
import com.qci.inventorymanagement.Model.Response;
import com.qci.inventorymanagement.Service.CatalogService;
@Controller

//@RestController //postman test

public class CatalogController {

	Response response = new Response();
	
	@Autowired
	private CatalogService catalogservice;
	
//	//postman
//	@GetMapping("/testMap")
//	public List<Category> findAllList() {
//		return catalogservice.getCatalog();
//	}
//	
//	@PostMapping("/savedata")
//	public Category saveNewData(@RequestBody Category cataCategory) {
//		
//		return catalogservice.savecatalog(cataCategory);
//	} //postman
	
	@GetMapping("/category")
	public String veiwallcatalog(Model model){
		model.addAttribute("category",  catalogservice.getCatalog());
		return "category";
	}
	
	@GetMapping("/categoryform")
	public String categoryform(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "categoryform";
	}
	
	@PostMapping("/savecategory")
	public String savecatalog(@ModelAttribute("category") Category category) {
		catalogservice.savecatalog(category);
		return "redirect:/category";
	}
	
	
	@GetMapping("/categoryedit/{id}")
	public String catalogId(@PathVariable Integer id, Model model ){
		Category category = catalogservice.getCatalogId(id);
		model.addAttribute("category", category);
//		Category category = 
			return	"categoryedit";
//		return "category";
	}
	
	
//	@PutMapping("/updatecatagory/{id}")
//	public Response updateCatagory(@RequestBody Category category){
//		
//		Category cataCategory = catalogservice.findSingleId(category.getId());
//		if(cataCategory==null) {
//			
//			 response.setResponse(400);
//		}else {
//			catalogservice.updatecata(category);
//			response.setResponse(200);
//		}
//		return response;
//	}
//	
	@GetMapping("/deleteCatalog/{id}")
	public String deleteCatalog(@PathVariable Integer id) {
		
		catalogservice.deleteCatalog(id);
		return "redirect:/category";
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

