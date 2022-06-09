package com.example.apiexcercise.service;

import com.example.apiexcercise.model.Item;
import com.example.apiexcercise.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
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

    public void deleteItem(String itemId) {
        boolean exists = itemRepository.existsByItemId(itemId);
        if(!exists){
            throw new IllegalStateException(
              "Item with id " + itemId + " does not exists."
            );
        }
        itemRepository.deleteByItemId(itemId);
    }

    public List<Item> getItem(String itemId) {
        return itemRepository.findByItemId(itemId);
    }

    public List<Item> getItems(List<String> itemIds) {
        // This also works
        /*
        List<Item> output = Collections.emptyList();
        for(String id :itemIds){
            output = Stream.concat(output.stream(), itemRepository.findByItemId(id).stream())
                    .collect(Collectors.toList());
        }
         return output;
         */

        return itemIds.stream()
                .map(itemId->itemRepository.findByItemId(itemId).get(0))
                .collect(Collectors.toList());
    }

    public List<Item> getItemsByBrand(String search){
        return this.getAll().stream()
                .filter(item -> item.getBrand().toLowerCase().
                        startsWith(search.toLowerCase()))
                .collect(Collectors.toList());
    }
}
