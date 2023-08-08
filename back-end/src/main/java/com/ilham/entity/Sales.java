package com.ilham.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeTransaksi;
    private String tanggalTransaksi;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Item> items;

    private int qty;
    private double totalDiskon;
    private double totalHarga;
    private double totalBayar;


}
