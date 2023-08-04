package org.example;

import org.example.entity.Item;
import org.example.repository.ItemRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ItemRepository itemRepository = new ItemRepository();
//        Item item1 = new Item(null, "khali2", null, 250);
//        itemRepository.save(item1);
//        System.out.println(itemRepository.findAll());

//        System.out.println(itemRepository.lessThan(210));
//        System.out.println(itemRepository.findItemType("%seeb%"));
//        System.out.println(itemRepository.between(90, 210));
//        List<String> names = Arrays.asList("seeb", "golabi");
//        System.out.println(itemRepository.specificItems(names));
        System.out.println(itemRepository.isNotNull());
    }
}
