package com.ilham.service;


import com.ilham.dtos.response.SalesResponse;
import com.ilham.entity.Customer;
import com.ilham.entity.Item;
import com.ilham.entity.Sales;
import com.ilham.exception.BadRequestException;
import com.ilham.repository.SalesRepository;
import com.ilham.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    public List<SalesResponse> getAllSales() {
        List<Sales> salesList = salesRepository.findAll();
        return Mapper.salesResponseList(salesList);
    }

    public SalesResponse getSalesById(Long id) {
        Sales sales = salesRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Penjualan dengan ID " + id + " Tidak di temukan"));
        return Mapper.salesResponse(sales);
    }

    @Transactional
    public SalesResponse saveSales(Sales sales) {
        Customer customer = customerService.getCustomerById(sales.getCustomer().getId());
        List<Item> items = new ArrayList<>();

        int price = 0;
        int qty = 0;

        for (Item item : sales.getItems()) {
            Item item1 = itemService.getItemById(item.getId());

            if (item1.getDeleted()){
                throw new BadRequestException("Item dengan ID " + item1.getId() + " tidak di temukan");
            }

            if (sales.getQty() == 0) {
                throw new BadRequestException("Masukan quantity untuk item : " + item1.getNamaItem());
            }

            if (sales.getQty() > item1.getStok()) {
                throw new BadRequestException("Stock tidak mencukupi");
            }

            items.add(item1);
            price += item1.getHargaSatuan() * sales.getQty();
            qty += sales.getQty();

            item1.setStok(item1.getStok() - sales.getQty());
            item1.setQty(0);
            itemService.saveItem(item1);
        }

        sales.setCodeTransaksi(UUID.randomUUID().toString());
        sales.setTanggalTransaksi(new Date().toString());
        sales.setCustomer(customer);
        sales.setQty(qty);
        sales.setItems(items);
        sales.setTotalDiskon(customer.getDiskon());
        sales.setTotalHarga(price);
        sales.setTotalBayar(price - customer.getDiskon());

        customer.setDiskon(0);
        salesRepository.save(sales);
        customerService.saveCustomer(customer);

        return Mapper.salesResponse(sales);
    }

}
