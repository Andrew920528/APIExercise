package com.example.apiexcercise.repository;

import com.example.apiexcercise.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository
        extends JpaRepository<Item,Integer> {

    List<Item> findAllByOrderByPriceDesc();
    List<Item> findByItemId(String itemId);


    @Transactional
    Integer deleteByItemId(String itemId);

    boolean existsByItemId(String itemId);
}
