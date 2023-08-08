package com.ilham.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private Long id;
    private String nama;
    private String contact;
}
