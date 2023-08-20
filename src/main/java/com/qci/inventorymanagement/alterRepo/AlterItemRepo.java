package com.qci.inventorymanagement.alterRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qci.inventorymanagement.alterEntity.AlterItem;

@Repository
public interface AlterItemRepo extends JpaRepository<AlterItem, Integer>{

}
