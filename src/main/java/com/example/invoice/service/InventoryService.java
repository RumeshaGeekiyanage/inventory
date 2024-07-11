package com.example.invoice.service;

import com.example.invoice.entity.InventoryDetails;
import com.example.invoice.entity.InventoryMaster;
import com.example.invoice.repository.InventoryMasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private InventoryMasterRepository inventoryMasterRepository;

    public InventoryMaster saveInventory(InventoryMaster inventoryMaster) {
        return inventoryMasterRepository.save(inventoryMaster);
    }

    public List<InventoryMaster> saveInventories(List<InventoryMaster> inventoryMasters) {
        return inventoryMasterRepository.saveAll(inventoryMasters);
    }

    public List<InventoryMaster> getInventoryMasters() {
        return inventoryMasterRepository.findAll();
    }

    public InventoryMaster getInventoryById(int id) {
        return inventoryMasterRepository.findById(id).orElse(null);
    }

    public InventoryMaster getInventoryByName(String name) {
        return inventoryMasterRepository.findByName(name);
    }

    public String deleteInventory(int id) {
        inventoryMasterRepository.deleteById(id);
        return "Inventory deleted successfully " + id;
    }

    public InventoryMaster updateInventory(@org.jetbrains.annotations.NotNull InventoryMaster inventoryMaster) {
        InventoryMaster existingInventory = inventoryMasterRepository.findById(inventoryMaster.getProductId()).orElse(null);
        assert existingInventory != null;
        existingInventory.setProductName(inventoryMaster.getProductName());
        existingInventory.setCategory(inventoryMaster.getCategory());
        existingInventory.setBrand(inventoryMaster.getBrand());
        existingInventory.setStock(inventoryMaster.getStock());
        existingInventory.setUnitPrice(inventoryMaster.getUnitPrice());
        existingInventory.setSupplier(inventoryMaster.getSupplier());
        existingInventory.setDateAdded(inventoryMaster.getDateAdded());
        existingInventory.setDateUpdated(inventoryMaster.getDateUpdated());
        existingInventory.setRemark(inventoryMaster.getRemark());

        return inventoryMasterRepository.save(existingInventory);
    }
}
