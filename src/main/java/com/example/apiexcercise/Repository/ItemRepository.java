package com.example.apiexcercise.Repository;

import com.example.apiexcercise.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository
        extends JpaRepository<Item,Integer> {

    List<Item> findAllByOrderByPriceDesc();
    List<Item> findByItemID(String itemID);


    @Transactional
    Integer deleteByItemID(String itemID);

    boolean existsByItemID(String itemID);
}
