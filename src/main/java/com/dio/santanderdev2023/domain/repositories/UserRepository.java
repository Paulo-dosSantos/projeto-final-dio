package com.dio.santanderdev2023.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.santanderdev2023.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByAccountNumber(String accountNumber);

}
