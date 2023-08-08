package com.ilham.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String contact;
    private String email;
    private String alamat;
    private double diskon;
    private String tipeDiskon;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

//    @Lob
//    @Type(type = "org.hibernate.type.ImageType")
//    private byte[] ktp;

    public boolean getDeleted() {
        return this.deleted;
    }

}
