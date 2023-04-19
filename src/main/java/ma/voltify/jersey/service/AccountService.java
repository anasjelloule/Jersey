package ma.voltify.jersey.service;

import java.util.List;

import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.entities.Account;
import ma.voltify.jersey.entities.Customer;
import ma.voltify.jersey.entities.User;

public interface AccountService {
    List<CustomerDto> customers();

    List<User> users();

    List<AccountDto> accounts();

    CustomerDto savecostomer(Customer customer);

    CustomerDto updatecostomer(long id, Customer customer) throws Exception;
}
