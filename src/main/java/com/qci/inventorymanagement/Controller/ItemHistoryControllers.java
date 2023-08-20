package com.qci.inventorymanagement.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.sequence.NextvalSequenceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qci.inventorymanagement.Model.Item;
import com.qci.inventorymanagement.Model.ItemHistory;
import com.qci.inventorymanagement.Service.ItemHistoryService;
import com.qci.inventorymanagement.Service.ItemService;
import com.qci.inventorymanagement.alterEntity.AlterItemhistory;

@Controller
public class ItemHistoryControllers {

	@Autowired private ItemHistoryService itemHistoryService;
	
	@Autowired private ItemService itemService;
	

@GetMapping("/itemhistory")
 public String viewItem(Model model) {
//		ItemHistory itemHistory = new ItemHistory();
 model.addAttribute("itemhistory", itemHistoryService.getItemHistory());
 return "itemhistory";
 }

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
	itemHistoryService.saveItemHistory(alterItemhistory);
	return "redirect:/itemhistory";
}

//saveitemhistorytk
@RequestMapping("/saveitemhistorytk")
public String saveItemHistorytk(@ModelAttribute("itemhistory") AlterItemhistory alterItemhistory) {
	
	int addtaken = 1;
	alterItemhistory.setAdd_taken(addtaken);
	
	int product_id =  alterItemhistory.getItemid();
	int product_quantity = alterItemhistory.getQuantity();
	
	List<AlterItemhistory> itemHistories= itemHistoryService.getalterHistory();

	int reqdata = product_quantity;


	for(AlterItemhistory item: itemHistories) {
	if(product_id == item.getItemid() && item.getAdd_taken() ==0 && item.getRemain() >0) {
		
	//  int remain = item.getRemain();
	  int taken = 1;
	  int price = item.getPrice();
	  int avg_qty = item.getRemain();
			
		if(reqdata > 0) {
			if(avg_qty <= reqdata) {
				reqdata = reqdata-avg_qty;
				item.setRemain(0);
				int total = avg_qty * price;
				int remain =0;
//				product_id,addortaken,price,quantity,total_price,remain
				item.setItemid(product_id);
				item.setAdd_taken(taken);
				item.setPrice(price);
				item.setTotal_price(total);
				item.setRemain(remain);		
				
				itemHistoryService.saveItemHistory(alterItemhistory);

			}
			
			else if (avg_qty > reqdata) {
				int value = 0;
				
				int remain = avg_qty - reqdata;
				item.setRemain(remain);
				int total = reqdata * price;
				item.setTotal_price(total);
				
				reqdata = 0;
				itemHistoryService.saveItemHistory(alterItemhistory);

				
			}
			else {
				itemHistoryService.saveItemHistory(alterItemhistory);

				return "redirect:/itemhistory";
			}
		}
		else {
			itemHistoryService.saveItemHistory(alterItemhistory);

			return "redirect:/itemhistory";
		}
	}
	else {
		
		return "redirect:/itemhistory";
	}
	}
	itemHistoryService.saveItemHistory(alterItemhistory);

			return "redirect:/itemhistory";
}

//saveitemhistorytk
//@RequestMapping("/saveitemhistorytk")
//public String saveItemHistorytk(@ModelAttribute("itemhistory") AlterItemhistory alterItemhistory) {
//	
//	int addtaken = 1;
//	alterItemhistory.setAdd_taken(addtaken);
//	
//	int itemid =  alterItemhistory.getItemid();
//	int quantity = alterItemhistory.getQuantity();
//	
////	System.out.println(quantity+"..."+itemid);
//	
//	List<AlterItemhistory> itemHistories= itemHistoryService.getalterHistory();
////	  System.out.println(alterItemhistory.getItemid()+"a");
////	System.out.println(itemHistories);
//
////	  Optional<Integer> firstItemId = itemHistories.stream()
////	          .map(AlterItemhistory::getId)
////	          .findFirst();
//	  
//	  
//	for(AlterItemhistory alterItemhistory2: itemHistories) {
//	
//		if(itemid == alterItemhistory2.getItemid()) {
//		
//	  int remain = alterItemhistory2.getRemain();
////	  	System.out.println("remian--"+remain);
//	  
//			
////		if(quantity > 0) {
////			if(remain < quantity) {
////				
//////				System.out.println("print1");
////				int quantity1 =  quantity - remain;
//////			    if(quantity1 == 0) {
//////
//////			    	break;
//////			    }
////			    
//////			    remain = 0;
////			    alterItemhistory.setQuantity(quantity1);
////			    int total = quantity * alterItemhistory2.getPrice();
//////			    alterItemhistory.setPrice(total);
//////			    System.out.println("total ="+ total + "Remain ="+ remain + "Quantity ="+ quantity + "itemid = "+ itemid );
////			}
////			
//			if (quantity <= remain ) {
////				int value = 0;
////				System.out.println("printing 2");
//				int remain1 =  alterItemhistory2.getRemain() - quantity;
//				
//				int total = quantity * alterItemhistory2.getPrice();
////				int zero = 0;
//				int price = alterItemhistory2.getPrice();
//				
//				alterItemhistory.setQuantity(quantity);
//				alterItemhistory2.setRemain(remain1);
//				alterItemhistory.setPrice(price);
//				alterItemhistory.setTotal_price(total);
//				
////				System.out.println("Remain = " + remain);
////				System.out.println("Quantity =" + quantity);
//				System.out.println("Total = "+ total);
//			}
//			else {
//				
//				return "redirect:/itemhistory";
//			}	}}
////		else {
////			return "redirect:/itemhistory";
//		
////		elseif ($avg_quantity >= $reqdata) {
////            $value = 0;
////            $remain = $avg_quantity - $reqdata;
////            $sql = DB::select(DB::raw("UPDATE fifo set remain=$remain WHERE id=$id"));
////            $total = $reqdata * $price;
////            $sql1 = DB::select(DB::raw("INSERT INTO fifo(product_id,addortaken,price,quantity,total_price,remain)values('$product_id',$taken,'$price','$reqdata','$total','$value')"));
////            $reqdata = 0;
////        } else {
////            return redirect('real');
////        }
////    } else {
////        return redirect('real');
////    }
////		if ($avg_quantity <= $reqdata) {
////            $reqdata = $reqdata - $avg_quantity;
////            $sql = DB::select(DB::raw("UPDATE fifo set remain=0,total_price=0 WHERE id=$id"));
////            $total = $avg_quantity * $price;
////            $remain = 0;
////            $sql1 = DB::select(DB::raw("INSERT INTO fifo(product_id,addortaken,price,quantity,total_price,remain)values('$product_id',$taken,'$price','$avg_quantity','$total','$remain')"));
//        
//			
//			
//			
//			
//	
////	}
//	itemHistoryService.saveItemHistory(alterItemhistory);
//
//			return "redirect:/itemhistory";
//}

@RequestMapping("/deleteitemhistory/{id}")
public String deleteById(@PathVariable Integer id) {
	itemHistoryService.deleteItemHistory(id);
	return "redirect:/itemhistory";
}



	
}
