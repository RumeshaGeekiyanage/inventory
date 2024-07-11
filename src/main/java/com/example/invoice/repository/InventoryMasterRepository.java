package com.example.invoice.repository;

import com.example.invoice.entity.InventoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMasterRepository extends JpaRepository<InventoryMaster, Integer> {
    InventoryMaster findByName(String name);
}
