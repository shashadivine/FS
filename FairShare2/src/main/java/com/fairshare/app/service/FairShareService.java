package com.fairshare.app.service;

import com.fairshare.app.model.Item;
import com.fairshare.app.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FairShareService {

    // Simulate storage for simplicity
    private List<Item> items;
    private Map<String, List<String>> itemAssignments = new HashMap<>();

    public List<Item> addItems(List<Item> items) {
        this.items = items;
        return items;
    }

    public String assignPersons(String itemName, List<String> persons) throws Exception {
        if (items == null || items.stream().noneMatch(item -> item.getName().equals(itemName))) {
            throw new Exception("Item not found");
        }
        itemAssignments.put(itemName, persons);
        return "Persons assigned to item " + itemName;
    }

    public Map<String, Double> calculateTotal() {
        Map<String, Double> totals = new HashMap<>();
        for (Item item : items) {
            List<String> assignedPersons = itemAssignments.get(item.getName());
            if (assignedPersons == null) continue;
            double share = item.getCost() / assignedPersons.size();
            for (String person : assignedPersons) {
                totals.put(person, totals.getOrDefault(person, 0.0) + share);
            }
        }
        return totals;
    }
}
