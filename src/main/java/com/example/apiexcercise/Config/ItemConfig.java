package com.example.apiexcercise.Config;

import com.example.apiexcercise.Model.Item;
import com.example.apiexcercise.Repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository repository) {
        return args -> {

            Item item1 = new Item(

                    "ITEM01",
                    "Item 1",
                    "NAPA",
                    100
            );

            Item item2 = new Item(
                    "ITEM02",
                    "Item 2",
                    "NAPA",
                    120
            );

            Item item3 = new Item(

                    "ITEM03",
                    "Item 3",
                    "NAPA",
                    203
            );

            Item item4 = new Item(
                    "ITEM04",
                    "Item 4",
                    "TAPA",
                    120
            );

            Item item5 = new Item(
                    "ITEM05",
                    "Item 5",
                    "TAPA",
                    120
            );

            Item item6 = new Item(
                    "ITEM06",
                    "Item 6",
                    "TAPA",
                    199
            );

            Item item7 = new Item(
                    "ITEM07",
                    "Item 7",
                    "Taiwan",
                    120
            );

            Item item8 = new Item(
                    "ITEM08",
                    "Item 8",
                    "Taiwan",
                    149
            );

            Item item9 = new Item(
                    "ITEM09",
                    "Item 9",
                    "Motion",
                    178
            );

            Item item10 = new Item(
                    "ITEM10",
                    "Item 10",
                    "Motion",
                    149
            );

            Item item11 = new Item(
                    "ITEM11",
                    "Item 11",
                    "Motion",
                    149
            );

            Item item12 = new Item(
                    "ITEM12",
                    "Item 12",
                    "NAPA",
                    130
            );

            Item item13 = new Item(
                    "ITEM13",
                    "Item 13",
                    "NAPAPA",
                    137
            );

            Item item14 = new Item(
                    "ITEM14",
                    "Item 14",
                    "GPC",
                    137
            );

            Item item15 = new Item(
                    "ITEM15",
                    "Item 15",
                    "GPC",
                    190
            );

            Item item16 = new Item(
                    "ITEM16",
                    "Item 16",
                    "TAPA",
                    193
            );


            Item item17 = new Item(
                    "ITEM17",
                    "Item 17",
                    "TAPA",
                    178
            );

            Item item18 = new Item(
                    "ITEM18",
                    "Item 18",
                    "NAPA",
                    99
            );

            Item item19 = new Item(
                    "ITEM19",
                    "Item 19",
                    "Tech",
                    303
            );

            Item item20 = new Item(
                    "ITEM20",
                    "Item 20",
                    "Tech",
                    528
            );


            repository.saveAll(
                    List.of(
                            item1,item2,item3,item4,item5,
                            item6,item7,item8,item9,item10,
                            item11,item12,item13,item14,item15,
                            item16,item17,item18,item19,item20
                    )
            );
        };
    }
}
