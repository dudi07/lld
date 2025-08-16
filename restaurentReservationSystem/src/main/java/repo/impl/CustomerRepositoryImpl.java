package restaurentReservationSystem.src.main.java.repo.impl;

import java.util.HashMap;
import java.util.Map;

import restaurentReservationSystem.src.main.java.model.Customer;
import restaurentReservationSystem.src.main.java.repo.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository{
    private Map<String, Customer>customerIdMap;

    
    public CustomerRepositoryImpl(){
        customerIdMap = new HashMap<>();
    }
    @Override
    public Customer saveCustomer(Customer customer) {
        if(customerIdMap.containsKey(customer.getUserId()))
            throw new IllegalArgumentException("Customer with this ID already exists");
        customerIdMap.put(customer.getUserId(), customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer == null || !customerIdMap.containsKey(customer.getUserId())) {
            throw new IllegalArgumentException("Customer does not exist");
        }
        customerIdMap.put(customer.getUserId(), customer);
        return customer;    
    }
}
