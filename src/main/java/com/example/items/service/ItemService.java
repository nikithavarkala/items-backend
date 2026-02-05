package com.example.items.service;

import com.example.items.exception.ItemNotFoundException;
import com.example.items.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final List<Item> items=new ArrayList<>();
    private Long counter = 1L;

    public Item addItem(Item item){
        item.setId(counter++);
        items.add(item);
        return item;
    }

    public Item getItemById(Long id){
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ItemNotFoundException("Item not found with Id "+ id));
    }

    public List<Item> getAllItems() {
        return items;
    }
}
