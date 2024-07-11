package com.example.invoice.controller;

import com.example.invoice.entity.InventoryMaster;
import com.example.invoice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/addInventory")
    public InventoryMaster addInventory(@RequestBody InventoryMaster inventoryMaster) {
        return service.saveInventory(inventoryMaster);
    }

    @PostMapping("/addInventories")
    public List<InventoryMaster> addInventories(@RequestBody List<InventoryMaster> inventoryMasters) {
        return service.saveInventories(inventoryMasters);
    }

    @GetMapping("/inventories")
    public List<InventoryMaster> findAllInventories() {
        return service.getInventoryMasters();
    }

    @GetMapping("/inventory/{id}")
    public InventoryMaster findInventoryById(@PathVariable int id) {
        return service.getInventoryById(id);
    }

    @GetMapping("/inventory/{name}")
    public InventoryMaster findInventoryByName(@PathVariable String name) {
        return service.getInventoryByName(name);
    }

    @PutMapping("/updateInventory")
    public InventoryMaster updateInventory(@RequestBody InventoryMaster inventoryMaster) {
        return service.updateInventory(inventoryMaster);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInventory(@PathVariable int id) {
        return service.deleteInventory(id);
    }
}
