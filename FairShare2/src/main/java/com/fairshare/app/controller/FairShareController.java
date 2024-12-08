package com.fairshare.app.controller;

import com.fairshare.app.model.Item;

import com.fairshare.app.service.FairShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FairShareController {

    @Autowired
    private FairShareService service;

    @PostMapping("/enteritems/add")
    public ResponseEntity<?> addItems(@RequestBody List<Item> items) {
        try {
            return ResponseEntity.ok(service.addItems(items));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/assignpersons/assign")
    public ResponseEntity<?> assignPersons(@RequestBody Map<String, Object> payload) {
        try {
            System.out.println("Payload received: " + payload);
            String itemName = (String) payload.get("itemName");
            List<String> persons = (List<String>) payload.get("persons");
            return ResponseEntity.ok(service.assignPersons(itemName, persons));
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }





    @GetMapping("/calculatetotal/calculate")
    public ResponseEntity<Map<String, Double>> calculateTotal() {
        return ResponseEntity.ok(service.calculateTotal());
    }
}
