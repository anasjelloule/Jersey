package ma.voltify.jersey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.voltify.jersey.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
