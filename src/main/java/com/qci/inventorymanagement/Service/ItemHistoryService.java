package com.qci.inventorymanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qci.inventorymanagement.Model.ItemHistory;
import com.qci.inventorymanagement.Repository.ItemHistoryRepo;
import com.qci.inventorymanagement.alterEntity.AlterItemhistory;
import com.qci.inventorymanagement.alterRepo.AlterItemhistoryRepo;

@Service
public class ItemHistoryService {

	@Autowired
	private ItemHistoryRepo itemhistoryrepo;
	
	@Autowired
	private AlterItemhistoryRepo alterItemhistoryRepo;
	
	public List<ItemHistory> getItemHistory() {
		// TODO Auto-generated method stub
		return itemhistoryrepo.findAll();
	}
	
	public List<AlterItemhistory> getalterHistory(){
		
	return alterItemhistoryRepo.findAll();
	}

	public AlterItemhistory saveItemHistory(AlterItemhistory alterItemhistory) {
		 return alterItemhistoryRepo.save(alterItemhistory);
		
	}
	
	
	public void deleteItemHistory(Integer id) {
		alterItemhistoryRepo.deleteById(id);
	}

}
