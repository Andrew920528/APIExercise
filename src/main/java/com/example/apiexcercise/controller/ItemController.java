package com.example.apiexcercise.controller;

import com.example.apiexcercise.model.Item;
import com.example.apiexcercise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public List<Item> getAll(){
        return itemService.getAll();
    }

    // This get method is unnecessary because getItems can get single item
    @GetMapping(path = "/single/{itemId}")
    public List<Item> getItem(@PathVariable("itemId") String itemId) {return itemService.getItem(itemId);}

    @GetMapping(path = "{itemIds}")
    public List<Item> getItems(@PathVariable("itemIds") List<String> itemIds) {
        // System.out.println(itemIds);
        return itemService.getItems(itemIds);
    }

    // Exercise 1: http:localhost8080/brand/T
    @GetMapping(path = "/brand/{search}")
    public List<Item> getItemsByBrand (@PathVariable("search") String search) {
        return itemService.getItemsByBrand(search);
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        this.itemService.addItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId){
        this.itemService.deleteItem(itemId);
    }

}
