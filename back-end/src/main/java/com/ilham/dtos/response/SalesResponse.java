package com.ilham.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SalesResponse {
    private Long id;
    private String codeTransaksi;
    private String tanggalTransaksi;
    private CustomerResponse customer;
    private List<ItemResponse> items;
    private int qty;
    private double totalDiskon;
    private double totalHarga;
    private double totalBayar;
}
