package ma.voltify.jersey.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.entities.Account;
import ma.voltify.jersey.entities.Customer;
import ma.voltify.jersey.entities.User;
import ma.voltify.jersey.mappers.Accountmapper;
import ma.voltify.jersey.repositories.AccountRepository;
import ma.voltify.jersey.repositories.CustomerRepository;
// import ma.voltify.jersey.repositories.RoleRepository;
import ma.voltify.jersey.repositories.UserRepository;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceimpl implements AccountService {
    private AccountRepository accrepository;
    private CustomerRepository customerrepository;
    private UserRepository userrepository;
    // private RoleRepository rolerepository;
    private Accountmapper accountmapper;

    @Override
    public List<AccountDto> accounts() {
        List<AccountDto> accounts = accrepository.findAll().stream().map(
                acc -> {
                    AccountDto account = accountmapper.fromAccount(acc);
                    account.setCustomerdto(accountmapper.fromCustomer(acc.getCustomer()));
                    return account;

                }).collect(Collectors.toList());

        return accounts;
    }

    @Override
    public List<CustomerDto> customers() {
        return customerrepository.findAll().stream().map(customer -> accountmapper.fromCustomer(customer)).toList();
    }

    @Override
    public CustomerDto savecostomer(Customer customer) {
        customer = customerrepository.save(customer);
        return accountmapper.fromCustomer(customer);
    }

    @Override
    public List<User> users() {
        return userrepository.findAll();
    }

    @Override
    public CustomerDto updatecostomer(long id, Customer customer) throws Exception {
        customerrepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        customer.setId(id);
        CustomerDto customerdto = accountmapper.fromCustomer(customerrepository.save(customer));
        return customerdto;
    }

}
