package com.azbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azbank.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findFirstByEmail(String email);

}
