package com.ilham.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaItem;
    private String unit;
    private int stok;
    private double hargaSatuan;
    private int qty;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

//    @Lob
//    private byte[] barang;

    public boolean getDeleted() {
        return this.deleted;
    }
}
