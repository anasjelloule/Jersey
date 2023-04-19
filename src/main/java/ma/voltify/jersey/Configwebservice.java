package ma.voltify.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.voltify.jersey.web.restapi.AccountRestJaxRsAPI;

// @Configuration
public class Configwebservice {
    // @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyservlet = new ResourceConfig();
        jerseyservlet.register(AccountRestJaxRsAPI.class);
        return jerseyservlet;
    }
}
