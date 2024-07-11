package com.example.invoice.repository;

import com.example.invoice.entity.InventoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDetailsRepository extends JpaRepository<InventoryMaster, Integer> {
}
