package com.example.apiexcercise.Service;

import com.example.apiexcercise.Model.Item;
import com.example.apiexcercise.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll(){
        return itemRepository.findAllByOrderByPriceDesc();
    }

    public void addItem(Item item) {
        // System.out.println(item);
        itemRepository.save(item);
    }

    public void deleteItem(String itemID) {
        boolean exists = itemRepository.existsByItemID(itemID);
        if(!exists){
            throw new IllegalStateException(
              "Item with id " + itemID + " does not exists."
            );
        }
        itemRepository.deleteByItemID(itemID);
    }

    public List<Item> getItem(String itemID) {
        return itemRepository.findByItemID(itemID);
    }

    public List<Item> getItems(List<String> itemIDs) {
        List<Item> output = Collections.emptyList();
        for(String id :itemIDs){
            output = Stream.concat(output.stream(), itemRepository.findByItemID(id).stream())
                    .collect(Collectors.toList());
        }
         return output;



//        return itemIDs.stream().map(itemId->itemRepository.findByItemID(itemId).get(0)).collect(Collectors.toList());
    }

    public List<Item> getItemsByBrand(String search){
        return this.getAll().stream()
                .filter(item -> item.getBrand().toLowerCase().
                        startsWith(search.toLowerCase()))
                .collect(Collectors.toList());
    }
}
