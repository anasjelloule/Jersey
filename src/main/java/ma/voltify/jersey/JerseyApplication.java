package ma.voltify.jersey;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.persistence.sdo.helper.ListWrapper;
import org.springframework.boot.CommandLineRunner;
// import org.springframework.remoting.rmi;;;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.transaction.annotation.Transactional;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.SchemaOutputResolver;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.ws.Endpoint;
import ma.voltify.jersey.Dtos.AccountDto;
import ma.voltify.jersey.Dtos.CustomerDto;
import ma.voltify.jersey.POJO.AccountsDtoPOJO;
import ma.voltify.jersey.entities.Account;
import ma.voltify.jersey.entities.Customer;
import ma.voltify.jersey.entities.Role;
import ma.voltify.jersey.entities.User;
import ma.voltify.jersey.enums.TypeAccount;
import ma.voltify.jersey.repositories.AccountRepository;
import ma.voltify.jersey.repositories.CustomerRepository;
// import ma.voltify.jersey.repositories.RoleRepository;
import ma.voltify.jersey.repositories.UserRepository;
import ma.voltify.jersey.web.soap.Accountservicesoap;

@SpringBootApplication
@Transactional
public class JerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseyApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner3(Accountservicesoap accountservicesoap,
			RepositoryRestConfiguration restconfig) {
		return args -> {
			restconfig.exposeIdsFor(Customer.class);
			// System.out.println("Anas");
			Endpoint.publish("http://0.0.0.0:8089/", accountservicesoap);
			System.out.println("Web service running on port 8089");

			JAXBContext jaxbContext = JAXBContext.newInstance(AccountsDtoPOJO.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			AccountsDtoPOJO accounts = new AccountsDtoPOJO();
			accounts.account = accountservicesoap.getAccounts();
			marshaller.marshal(accounts, new File("Account.xml"));
			System.out.println("µµµµµµµµµµµµµµµµµµµµµµµµµ marshaller 2 generation Schema");
			jaxbContext.generateSchema(new SchemaOutputResolver() {

				@Override
				public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
					File output = new File("accountspojo.xsd");
					StreamResult result = new StreamResult(output);
					return result;
				}
			});
			System.out.println("µµµµµµµµµµµµµµµµµµµµµµµµµ Unmarshaller 3");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			// AccountsDtoPOJO accounts2 = (AccountsDtoPOJO) unmarshaller.unmarshal(new
			// File("Account.xml"));
			// System.out.println(accounts2.account);
			System.out.println("µµµµµµµµµµµµµµµµµµµµµµµµµ Unmarshaller From Url");
			URL url = new URL("http://thegamesdb.net/api/GetGame.php?id=2");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.addRequestProperty("User-Agent", "Mozilla/4.76");
			InputStream is = http.getInputStream();
		};
	}

	// @Bean
	/*
	 * public CommandLineRunner comnade1(AccountRepository acc, CustomerRepository
	 * customer, UserRepository user,
	 * RoleRepository role) {
	 * return args -> {
	 * int i = 0;
	 * 
	 * role.save(Role.builder().name("Admin").description("Has full access").build()
	 * );
	 * role.save(Role.builder().name("Editor").description("Has Editor access").
	 * build());
	 * role.save(Role.builder().name("Manager").description("Has Manger access").
	 * build());
	 * Stream.of("Anas", "Tarik", "Mouad").forEach(name -> {
	 * 
	 * User user_ = user.save(User.builder().name(name).email(name + "@gmail.com")
	 * // .role(role.findById().get())
	 * .build());
	 * user_.setRole(role.findById(user_.getId()).get());
	 * user.save(user_);
	 * });
	 * Stream.of("Ali", "Hamza", "Khalid", "Fati", "Ayoub", "Wissal").forEach(name
	 * -> {
	 * customer.save(Customer.builder().name(name).email(name + "@gmail.com")
	 * .user(user.findById((long) 3).get()).build());
	 * });
	 * customer.findAll()
	 * .forEach(cust -> acc.save(Account.builder().id(UUID.randomUUID().toString())
	 * .balance(Math.random() * cust.getId())
	 * .customer(cust)
	 * .user(user.findById((long) 3).get())
	 * .createdAt(new Date()).type(
	 * Math.random() > 0.5 ? TypeAccount.CURRENT_ACCOUNT :
	 * TypeAccount.SAVING_ACCOUNT)
	 * .build()));
	 * 
	 * // acc.save(new Account(UUID.randomUUID().toString(), 900, new Date(),
	 * // TypeAccount.CURRENT_ACCOUNT));
	 * };
	 * 
	 * }
	 */
}
