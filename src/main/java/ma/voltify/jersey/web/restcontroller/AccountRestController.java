package ma.voltify.jersey.web.restcontroller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.entities.Customer;
import ma.voltify.jersey.service.AccountServiceimpl;

// @RestController
// @RequestMapping({ "/restcontroller", "/restcontroller/" })
// @AllArgsConstructor
public class AccountRestController {
    private AccountServiceimpl accountservice;

    @GetMapping({ "/accounts", "/accounts/" })
    public ResponseEntity<List<AccountDto>> getAccounts() {
        return ResponseEntity.status(200).body(accountservice.accounts());
    }

    @GetMapping(path = { "/customers", "/customers/" }, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public List<CustomerDto> getCustomers() {
        return accountservice.customers();
    }
    // public Response getCustomers() {
    // return Response.status(200).entity(accountservice.customers()).build();
    // }

    @PostMapping({ "/customers", "/customers/" })
    public Response savecustomer(Customer customer) {
        accountservice.savecostomer(customer);
        return Response.status(200).entity(customer).build();
    }

    @PutMapping("/customers/{id}")
    public Response updatecustomer(@PathVariable("id") long id, @RequestBody Customer customer)
            throws Exception {
        ;
        // customer.setId(id);
        // accountservice.savecostomer(customer);
        return Response.status(200).entity(accountservice.updatecostomer(id, customer)).build();
    }
}
