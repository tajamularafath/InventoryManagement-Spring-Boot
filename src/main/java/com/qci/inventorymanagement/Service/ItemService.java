package com.qci.inventorymanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qci.inventorymanagement.Model.Item;
import com.qci.inventorymanagement.Repository.ItemRepo;
import com.qci.inventorymanagement.alterRepo.AlterItemRepo;

@Service
public class ItemService {

	@Autowired
	private ItemRepo itemrepo;
	
	@Autowired
	private AlterItemRepo alterItemRepo;


public List<Item> findAllItem(){
	return itemrepo.findAll();
}

public Item saveItem(Item item) {
	return itemrepo.save(item);
}

public Item getItemId(Integer id) {
	
	Optional<Item>optional = itemrepo.findById(id);
	Item item = null;
	
	if(optional.isPresent()) {
		item=optional.get();
	}
	else {
		System.out.println("Item not found: "+id);
	}
	return item;
}

public Item updateItem(Item item) {
	
	Item item2 = itemrepo.findById(item.getId()).orElse(null);
	
	item2.setItemtitle(item.getItemtitle());
	item2.setCategory(item.getCategory());
	item2.setSubcategory(item.getSubcategory());
	item2.setUpdated_date(item.getUpdated_date());
	
	return itemrepo.save(item);
}

public String deleteItem(Integer id) {
	
	alterItemRepo.deleteById(id);
	
	return "deleted";
}

















}