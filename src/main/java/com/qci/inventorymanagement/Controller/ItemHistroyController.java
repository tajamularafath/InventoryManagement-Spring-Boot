package com.qci.inventorymanagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qci.inventorymanagement.Model.Item;
import com.qci.inventorymanagement.Model.ItemHistory;
import com.qci.inventorymanagement.Repository.ItemHistoryRepo;
import com.qci.inventorymanagement.Service.ItemHistoryService;
import com.qci.inventorymanagement.Service.ItemService;
import com.qci.inventorymanagement.alterEntity.AlterItemhistory;


//@Controller 
//@RestController
public class ItemHistroyController {
	
	@Autowired
	private ItemHistoryRepo historyRepo;

	@Autowired ItemHistoryService itemhistoryservice;
	
	@Autowired ItemService itemService;
	
@GetMapping("/itemhistory")
public String viewItem(Model model) {
//	ItemHistory itemHistory = new ItemHistory();
	model.addAttribute("itemhistory", itemhistoryservice.getItemHistory());
	return "itemhistory";
}

//@GetMapping("/postsave")
//public List<ItemhistoryItem>joineent(){
//	
//	return itemhistoryservice.getItemHistory();
//}

@GetMapping("/additemhistoryform")
public String additemHistoryForm(Model model) {
	ItemHistory itemhistory = new ItemHistory();
	List<Item> item =  itemService.findAllItem();

	model.addAttribute("itemhistory", itemhistory);
	model.addAttribute("item", item);
 	
	return "additemhistoryform";
}

@GetMapping("/takenitemhistoryform")
public String takenitemHistoryForm(Model model) {
	ItemHistory itemhistory = new ItemHistory();
	List<Item> item =  itemService.findAllItem();

	model.addAttribute("itemhistory", itemhistory);
	model.addAttribute("item", item);
 	
	return "takenitemhistoryform";
}

@RequestMapping("/saveitemhistory")
public String saveItemHistory(@ModelAttribute("itemhistory") AlterItemhistory alterItemhistory, Model model ) {
      
	int multotalprice = alterItemhistory.getPrice() * alterItemhistory.getQuantity();
//    int subremaining = alterItemhistory.getQuantity() - alterItemhistory.get
    System.out.println(multotalprice);
    alterItemhistory.setTotal_price(multotalprice);
    
    alterItemhistory.setRemain(alterItemhistory.getQuantity());
//    List<ItemHistory> Itemhistory2 = itemhistoryservice.getItemHistory();
    
//    int remainnum = Itemhistory2.();
//    System.out.println(Itemhistory2.toString());
    
//    int quantity = alterItemhistory.getQuantity();
    
    
//    if(remainnum==0) {
//    	
//    	alterItemhistory.setRemain(quantity);
//    	System.out.println(quantity);
//    }
//    else { 
//    	}
//    int newremain = alterItemhistory.getQuantity()+ remainnum;
//    alterItemhistory.setRemain(newremain);
//	System.out.println(newremain);
    
    
	itemhistoryservice.saveItemHistory(alterItemhistory);
	return "redirect:/itemhistory";
}

@RequestMapping("/saveitemhistorytk")
//@Query(value = "SELECT * FROM itemhistory WHERE add_taken=0 AND remain>0 AND id=:id ORDER BY id ASC", nativeQuery = true)
public String saveItemHistorytk(@ModelAttribute("itemhistory") AlterItemhistory alterItemhistory, Model model ) {

	int addtaken=1;
    int data = alterItemhistory.setAdd_taken(addtaken);
    

  List<AlterItemhistory> itemHistories= itemhistoryservice.getalterHistory();
  System.out.println(alterItemhistory.getItemid()+"a"); 

  Optional<Integer> firstItemId = itemHistories.stream()
          .map(AlterItemhistory::getId)
          .findFirst();
  
  int itemId = firstItemId.orElse(0); // set default value to 0 if firstItemId is empty
  

  System.out.println(firstItemId+"djjsknmckm");
  
for(AlterItemhistory ftiItemHistory: itemHistories) {

//	Queue<AlterItemhistory> ftiQueue = new LinkedList<>();
	
//	if(firstItemId == ftiItemHistory.getId()) {
		
//	}
	
//	for(int i=1;i<=ftiItemHistory.getItemid();i++) {
	
	if (itemId == ftiItemHistory.getId()) {
		
		int data1 =  ftiItemHistory.getRemain() - alterItemhistory.getQuantity();
		System.out.println("running");
		System.out.println(ftiItemHistory.getRemain());
		System.out.println(itemId);
		
			if(itemId == ftiItemHistory.getId()) {
					ftiItemHistory.setRemain(data1);
					int lastPrice = ftiItemHistory.getPrice();

					int muldata = ftiItemHistory.getPrice() * alterItemhistory.getQuantity();
					alterItemhistory.setTotal_price(muldata);
					alterItemhistory.setPrice(lastPrice);		
					if(ftiItemHistory.getRemain() == 0) {
						alterItemhistory.setRemain(0);
						itemId++;
						System.out.println("itemId"+itemId);
					}
//			}
	}}

	if(alterItemhistory.getItemid() == ftiItemHistory.getItemid() ) {
	
		System.out.println(ftiItemHistory.getItemid()+"check");
		
//		int lastPrice = ftiItemHistory.getPrice();
//		
//		int muldata = ftiItemHistory.getPrice() * alterItemhistory.getQuantity();
//		alterItemhistory.setTotal_price(muldata);
//		alterItemhistory.setPrice(lastPrice);
//		
//		System.out.println("total price :"+muldata+"===,==="+"price:"+lastPrice);
			
//		if(alterItemhistory.getQuantity()>=ftiItemHistory.getRemain()) {
//			
////			for(int i=0;i<=ftiItemHistory.getId();i++) {
//			
//		}
			//		}
//		else {
//			int data2 = ftiItemHistory.getRemain() - alterItemhistory.getQuantity();
//			ftiItemHistory.setRemain(data2);
//		}
	}}
itemhistoryservice.saveItemHistory(alterItemhistory);
return "redirect:/itemhistory";
}


@RequestMapping("/deleteitemhistory/{id}")
public String deleteById(@PathVariable Integer id) {
	itemhistoryservice.deleteItemHistory(id);
	return "redirect:/itemhistory";
}
}

//@RequestMapping("/saveitemhistorytk")
//@Query(value = "SELECT * FROM itemhistory WHERE add_taken=0 AND remain>0 AND id=:id ORDER BY id ASC", nativeQuery = true)
//public String saveItemHistorytk(@ModelAttribute("itemhistory") AlterItemhistory alterItemhistory, Model model ) {
//
//	int addtaken=1;
//  int data = alterItemhistory.setAdd_taken(addtaken);
////  System.out.println(data + " Taken printing 1");
//  
////System.out.println(alterItemhistory.getId()+"welcome");
//
////List<Item> item = itemService.findAllItem() ;
//  
//
//  List<AlterItemhistory> itemHistories= itemhistoryservice.getalterHistory();
//System.out.println(alterItemhistory.getItemid()+"a"); 
////System.out.println(item.getId()+":5");
//
//
//for(AlterItemhistory ftiItemHistory: itemHistories) {
//	
////	System.out.println("done"+ftiItemHistory.getItemid());
////	if(ftiItemHistory.getId()>ftiItemHistory.getId())
////	{
//
//	if(alterItemhistory.getItemid() == ftiItemHistory.getItemid()) {
//		
//		int lastPrice = ftiItemHistory.getPrice();
//		
//		int muldata = ftiItemHistory.getPrice() * alterItemhistory.getQuantity();
//		alterItemhistory.setTotal_price(muldata);
//		alterItemhistory.setPrice(lastPrice);
//		
//		System.out.println("total price :"+muldata+"===,==="+"price:"+lastPrice);
//			
//		if(alterItemhistory.getQuantity()>=ftiItemHistory.getRemain()) {
//			
//			for(int i=0;i<=ftiItemHistory.getId();i++) {
//				
//			int data1 = alterItemhistory.getQuantity() - ftiItemHistory.getRemain();
//			alterItemhistory.setRemain(data1);
//		}}
//		else {
//			int data2 = ftiItemHistory.getRemain() - alterItemhistory.getQuantity();
//			alterItemhistory.setRemain(data2);
//		}
//	}}
//itemhistoryservice.saveItemHistory(alterItemhistory);
////for (Item currentItem : item) {
//////	System.out.println(currentItem.getId());
////	if(alterItemhistory.getItemid() == currentItem.getId()) {
////		
////		
////		
////		System.out.println(alterItemhistory.getItemid()+ "<html and db> " +currentItem.getStatus());
////	}
////	else {
//////		System.out.println(currentItem.getId());
////		System.out.println("Not found");
////	}
////}
//return "redirect:/itemhistory";
//}
