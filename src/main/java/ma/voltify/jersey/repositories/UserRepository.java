package ma.voltify.jersey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.voltify.jersey.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
