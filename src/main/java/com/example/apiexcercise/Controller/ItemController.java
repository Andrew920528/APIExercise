package com.example.apiexcercise.Controller;

import com.example.apiexcercise.Model.Item;
import com.example.apiexcercise.Service.ItemService;
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
    @GetMapping(path = "/single/{itemID}")
    public List<Item> getItem(@PathVariable("itemID") String itemID) {return itemService.getItem(itemID);}

    @GetMapping(path = "{itemIDs}")
    public List<Item> getItems(@PathVariable("itemIDs") List<String> itemIDs) {
        // System.out.println(itemIDs);
        return itemService.getItems(itemIDs);
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

    @DeleteMapping(path = "{itemID}")
    public void deleteItem(@PathVariable("itemID") String itemID){
        this.itemService.deleteItem(itemID);
    }

}
