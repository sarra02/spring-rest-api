package tn.sarra.simplerestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sarra.simplerestapi.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
}
