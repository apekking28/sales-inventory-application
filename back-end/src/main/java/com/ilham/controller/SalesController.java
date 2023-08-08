package com.ilham.controller;

import com.ilham.dtos.response.SalesResponse;
import com.ilham.entity.Sales;
import com.ilham.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<SalesResponse> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public SalesResponse getSalesById(@PathVariable Long id) {
        return salesService.getSalesById(id);
    }

    @PostMapping
    public SalesResponse saveSales(@RequestBody Sales sales) {
        return salesService.saveSales(sales);
    }

}
