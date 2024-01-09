package com.enigma.anriticket.service;

import com.enigma.anriticket.dto.customer.request.CustomerRequestAuth;
import com.enigma.anriticket.entity.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerRequestAuth customerRequestAuth);
}
