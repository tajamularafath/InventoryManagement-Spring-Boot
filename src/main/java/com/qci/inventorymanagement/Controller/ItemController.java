package com.qci.inventorymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qci.inventorymanagement.Model.Category;
import com.qci.inventorymanagement.Model.Item;
import com.qci.inventorymanagement.Model.Subcategory;
import com.qci.inventorymanagement.Service.CatalogService;
import com.qci.inventorymanagement.Service.ItemService;
import com.qci.inventorymanagement.Service.SubcategoryService;

@Controller
//@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CatalogService catalogService; 
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@GetMapping("/item")
	public String viewItem(Model model) {
		model.addAttribute("item", itemService.findAllItem());
//		model.addAttribute("catagory", catalogService.getCatalog());

		return "item";
	}
	
	@GetMapping("/items")
	public List<Item> viewItem1(Model model) {
		model.addAttribute("item", itemService.findAllItem());
//		model.addAttribute("catagory", catalogService.getCatalog());

		return itemService.findAllItem();
	}
	
	@GetMapping("/itemform")
	public String addItem(Model model) {
		Item item = new Item();
		List<Category> category = catalogService.getCatalog();
		model.addAttribute("categories", category);
		List<Subcategory> subcategory = subcategoryService.getSubcategory();
		model.addAttribute("subcategory", subcategory);
		model.addAttribute("item", item);
		return "itemform";
	}
	
	@RequestMapping("/saveitem")
	public String saveItem(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/item";
	}
	
	@GetMapping("/itemedit/{id}")
	public String itemId(@PathVariable Integer id, Model model) {
		Item item = itemService.getItemId(id);
		model.addAttribute("item", item);
		List<Category> category = catalogService.getCatalog();
		model.addAttribute("categories", category);
		List<Subcategory> subcategory = subcategoryService.getSubcategory();
		model.addAttribute("subcategory", subcategory);
		return "itemedit";
	}
	
	@RequestMapping("deleteitem/{id}")
	public String deleteItem(@PathVariable Integer id) {
		
		itemService.deleteItem(id);
		return "redirect:/item";
	}
	
}
