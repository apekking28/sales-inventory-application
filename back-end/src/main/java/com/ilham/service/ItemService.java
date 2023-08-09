package com.ilham.service;

import com.ilham.entity.Customer;
import com.ilham.entity.Item;
import com.ilham.exception.BadRequestException;
import com.ilham.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAllItems() {
        return itemRepository.findAll().stream()
                .filter(item -> !item.getDeleted())
                .sorted(Comparator.comparingLong(Item::getId))
                .collect(Collectors.toList());
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Item dengan ID " + id + " tidak di temukan"));
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        Item findItem = getItemById(id);


        Item savedItem = Item.builder()
                .id(findItem.getId())
                .namaItem(item.getNamaItem())
                .stok(item.getStok())
                .unit(item.getUnit())
                .hargaSatuan(item.getHargaSatuan())
                .build();

        return itemRepository.save(savedItem);
    }


    public void deleteItem(Long id) {
        Item findItem = getItemById(id);
        findItem.setDeleted(true);
        saveItem(findItem);
    }
}
