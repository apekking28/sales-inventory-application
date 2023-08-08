package com.ilham.util;

import com.ilham.dtos.response.CustomerResponse;
import com.ilham.dtos.response.ItemResponse;
import com.ilham.dtos.response.SalesResponse;
import com.ilham.entity.Item;
import com.ilham.entity.Sales;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static SalesResponse salesResponse(Sales sales) {

        List<ItemResponse> itemResponses = new ArrayList<>();

        for (Item item : sales.getItems()) {
            ItemResponse item1 = ItemResponse.builder()
                    .id(item.getId())
                    .namaItem(item.getNamaItem())
                    .hargaSatuan(item.getHargaSatuan())
                    .build();

            itemResponses.add(item1);
        }


        CustomerResponse customerResponse = CustomerResponse.builder()
                .id(sales.getCustomer().getId())
                .nama(sales.getCustomer().getNama())
                .contact(sales.getCustomer().getContact())
                .build();

        return SalesResponse.builder()
                .id(sales.getId())
                .codeTransaksi(sales.getCodeTransaksi())
                .tanggalTransaksi(DateFormat.convertDateFormat(sales.getTanggalTransaksi()))
                .customer(customerResponse)
                .items(itemResponses)
                .qty(sales.getQty())
                .totalDiskon(sales.getTotalDiskon())
                .totalHarga(sales.getTotalHarga())
                .totalBayar(sales.getTotalBayar())
                .build();
    }

    public static List<SalesResponse> salesResponseList(List<Sales> sales) {
        List<SalesResponse> responses = new ArrayList<>();

        for (Sales sales1 : sales) {
            SalesResponse salesResponse = Mapper.salesResponse(sales1);

            responses.add(salesResponse);
        }

        return responses;
    }


}
