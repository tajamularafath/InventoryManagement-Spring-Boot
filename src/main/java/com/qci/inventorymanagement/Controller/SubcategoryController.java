package com.qci.inventorymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qci.inventorymanagement.JoinEntity.CategorySubcategoryJoin;
import com.qci.inventorymanagement.JoinEntity.ItemhistoryItem;
import com.qci.inventorymanagement.Model.Category;
import com.qci.inventorymanagement.Model.Response;
import com.qci.inventorymanagement.Model.Subcategory;
import com.qci.inventorymanagement.Service.CatalogService;
import com.qci.inventorymanagement.Service.SubcategoryService;
import com.qci.inventorymanagement.alterEntity.AlterSubcategory;

@Controller
//@RestController //postman mapping checking
public class SubcategoryController {

	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@Autowired
	private CatalogService cataService;

//	//for postman mapping checking
//	@GetMapping("/testsub")
//	public List<Subcategory> findallList(){
//		return subcategoryService.getSubcategory();
//	}
//	@PostMapping("/savesub")
//	public AlterSubcategory saveData(@RequestBody AlterSubcategory subcategory) {
//		return subcategoryService.savesubcategory(subcategory);
//	} //postman
//	
@GetMapping("/subcategory")
public String viewSubcategory(Model model) {
//	Subcategory subcategory = new Subcategory();
	model.addAttribute("subcategory", subcategoryService.getSubcategory());
//	model.addAttribute("catagory", cataService.getCatalog());
	return "subcategory";
}

//@GetMapping("/getshow")
//public List<Subcategory> joins(){
//	
//	return subcategoryService.getSubcategory();
//}

@GetMapping("/subcategoryform")
public String subcategoryform(Model model){
	Subcategory subcategory = new Subcategory();
	List<Category> category = cataService.getCatalog();
	
	model.addAttribute("subcategory", subcategory);
	model.addAttribute("categories", category);
	return "subcategoryform";
}
	
@PostMapping("/savesubcategory")
public Object saveSubcategory(@ModelAttribute("subcategory") AlterSubcategory altersubcategory) {
	subcategoryService.savesubcategory(altersubcategory);
//	return altersubcategory;
	return "redirect:/subcategory";
}


@GetMapping("/subcategoryedit/{id}")
public String editsubcategory(@PathVariable Integer id, Model model) {
	
	AlterSubcategory subcategory = subcategoryService.findedit(id);
	List<Category> category = cataService.getCatalog();
	model.addAttribute("subcategory", subcategory);
	model.addAttribute("categories", category);
	return "subcategoryedit";
}
@PostMapping("/updatesubcategory")
public Object updatesub(@ModelAttribute("subcategory") AlterSubcategory altersubcategory) {
	subcategoryService.updatealterSubcategory(altersubcategory);
//	return altersubcategory;
	return "redirect:/subcategory";
}


Response response = new Response();

@RequestMapping("/deletesubcategory/{id}")
public String deleteSubcatelog(@PathVariable Integer id) {
	
	subcategoryService.deletesubcategory(id);
	return "redirect:/subcategory";
}

//@PutMapping("/updatealterdata")
//public Response updatemet(AlterSubcategory alterSubcategory) {
//	
//	AlterSubcategory alter = subcategoryService.findedit(alterSubcategory.getId());
//	if(alter == null) {
//		response.setResponse(400);
//	}
//	else {
//		subcategoryService.updatealterSubcategory(alterSubcategory);
//		response.setResponse(200);
//	}
//	return response;
//	
//}
//@GetMapping("/deleteSubcategory/{id}")
//public String deleteSubcategory(@PathVariable Integer id) {
//	subcategoryService.deleteSubcategory(id);
//	return "redirect:/subcategory";
//}
	
}
