package com.qci.inventorymanagement.alterRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qci.inventorymanagement.alterEntity.AlterItemhistory;

@Repository
public interface AlterItemhistoryRepo extends JpaRepository<AlterItemhistory, Integer> {

}
