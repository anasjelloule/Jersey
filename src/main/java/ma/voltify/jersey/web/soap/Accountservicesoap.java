package ma.voltify.jersey.web.soap;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.service.AccountServiceimpl;

// @Data
// @RequiredArgsConstructor
@Service
@AllArgsConstructor
// @NoArgsConstructor
@WebService(serviceName = "Accountws")
public class Accountservicesoap {
    private AccountServiceimpl accountservice;

    @WebMethod(operationName = "getAccounts")
    @WebResult(name = "Account")
    public List<AccountDto> getAccounts() {
        return accountservice.accounts();
        // return null;
    }

    @WebMethod(operationName = "getCustomers")
    @WebResult(name = "Customer")
    public List<CustomerDto> getCustomers() {
        return accountservice.customers();
    }

    @WebMethod(operationName = "getABS")
    @WebResult(name = "ABS")
    public double getABS(@WebParam(name = "n") double n) {
        return n > 0 ? n : n * -1;
    }

}
