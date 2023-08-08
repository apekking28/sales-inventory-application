package com.ilham.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemResponse {
    private Long id;
    private String namaItem;
    private double hargaSatuan;
}
