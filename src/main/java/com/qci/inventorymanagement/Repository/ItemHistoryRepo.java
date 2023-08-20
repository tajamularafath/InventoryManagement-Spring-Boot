package com.qci.inventorymanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qci.inventorymanagement.JoinEntity.ItemhistoryItem;
import com.qci.inventorymanagement.Model.ItemHistory;
import com.qci.inventorymanagement.alterEntity.AlterItemhistory;

@Repository
public interface ItemHistoryRepo extends JpaRepository<ItemHistory , Integer> {

	@Query("select new com.qci.inventorymanagement.JoinEntity.ItemhistoryItem (b.id, a.itemtitle, b.created_date, b.updated_date,"
			+ "b.add_taken, b.price, b.quantity, b.remain, b.total_price)from ItemHistory b inner join Item a on b.itemid=a.id")
	public List<ItemhistoryItem> join();
	
	@Query(value = "SELECT * FROM ItemHistory WHERE add_taken=0 AND remain>0 AND id=:id ORDER BY id ASC", nativeQuery = true)

	public List<ItemHistory> findupdate(@Param("id") Long id );
}
