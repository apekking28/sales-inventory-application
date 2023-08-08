package com.ilham.service;

import com.ilham.entity.Customer;
import com.ilham.exception.BadRequestException;
import com.ilham.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll().stream()
                .filter(customer -> !customer.getDeleted())
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(Collectors.toList());
    }


    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Customer dengan ID " + id + " Tidak Ditemukan"));
    }

    public Customer saveCustomer(Customer customer) {

        if (!customer.getTipeDiskon().equalsIgnoreCase("persentase") &&
                !customer.getTipeDiskon().equalsIgnoreCase("fix")) {
            customer.setDiskon(0);
        }

        if (customer.getDiskon() < 0) {
            customer.setDiskon(0);
        }



        return customerRepository.save(customer);
    }


    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customer.setDeleted(true);
        saveCustomer(customer);
    }

    public Customer editCustomer(Long id, Customer customer) {
        Customer updatedCustomer = getCustomerById(id);

        Customer savedCustomer = Customer.builder()
                .id(updatedCustomer.getId())
                .nama(customer.getNama())
                .contact(customer.getContact())
                .email(customer.getEmail())
                .alamat(customer.getAlamat())
                .diskon(updatedCustomer.getDiskon())
                .tipeDiskon(updatedCustomer.getTipeDiskon())
//                .ktp(updatedCustomer.getKtp())
                .build();

        return saveCustomer(savedCustomer);
    }
}
