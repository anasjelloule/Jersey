package ma.voltify.jersey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.voltify.jersey.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
