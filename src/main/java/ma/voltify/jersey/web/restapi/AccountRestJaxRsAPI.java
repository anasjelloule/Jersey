package ma.voltify.jersey.web.restapi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import lombok.AllArgsConstructor;
import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.entities.Customer;
import ma.voltify.jersey.service.AccountServiceimpl;

// @Service
// @AllArgsConstructor
// @Path("/api")
public class AccountRestJaxRsAPI {
    private AccountServiceimpl accountservice;

    @Path("/accounts")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAccounts() {
        return Response.status(200).entity(accountservice.accounts()).build();
    }

    @Path("/customers")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<CustomerDto> getCustomers() {
        return accountservice.customers();
    }
    // public Response getCustomers() {
    // return Response.status(200).entity(accountservice.customers()).build();
    // }

    @Path("/customers")
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    public Response savecustomer(Customer customer) {
        accountservice.savecostomer(customer);
        return Response.status(200).entity(customer).build();
    }

    @Path("/customers/{id}")
    @PUT
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatecustomer(@PathParam("id") long id, @RequestBody Customer customer)
            throws Exception {
        ;
        // customer.setId(id);
        // accountservice.savecostomer(customer);
        return Response.status(200).entity(accountservice.updatecostomer(id, customer)).build();
    }
}
