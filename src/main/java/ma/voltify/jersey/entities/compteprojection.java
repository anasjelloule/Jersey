package ma.voltify.jersey.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customer", types = Customer.class)
public interface compteprojection {
    public String getEmail();
}
