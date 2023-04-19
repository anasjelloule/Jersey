package ma.voltify.jersey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ma.voltify.jersey.entities.Account;
import ma.voltify.jersey.enums.TypeAccount;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, String> {
    @RestResource(path = "/ByType")
    public List<Account> findByType(@Param("t") TypeAccount type);
}
