package restaurentReservationSystem.src.main.java.repo;

import restaurentReservationSystem.src.main.java.model.Customer;

public interface CustomerRepository {

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
}
