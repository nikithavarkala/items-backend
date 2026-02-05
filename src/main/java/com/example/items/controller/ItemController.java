package com.example.items.controller;

import com.example.items.model.Item;
import com.example.items.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Map<String,Object>> addItem(@Valid @RequestBody Item item){
        Item savedItem = itemService.addItem(item);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Item added successfully");
        response.put("data", savedItem);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item res = itemService.getItemById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
}
