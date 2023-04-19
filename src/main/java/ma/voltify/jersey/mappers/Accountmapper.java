package ma.voltify.jersey.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.entities.Account;
import ma.voltify.jersey.entities.Customer;

// Mapstruct
@Service
public class Accountmapper {
    public Customer fromCustomerDto(CustomerDto customerdto) {
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(customerdto, customer);
        return customer;
    }

    public CustomerDto fromCustomer(Customer customer) {
        CustomerDto customerdto = CustomerDto.builder().build();
        BeanUtils.copyProperties(customer, customerdto);
        return customerdto;
    }

    public Account fromAccountDto(AccountDto accountdto) {
        Account account = Account.builder().build();
        BeanUtils.copyProperties(accountdto, account);
        return account;
    }

    public AccountDto fromAccount(Account account) {
        AccountDto accountDto = AccountDto.builder().build();
        BeanUtils.copyProperties(account, accountDto);
        return accountDto;
    }

}
