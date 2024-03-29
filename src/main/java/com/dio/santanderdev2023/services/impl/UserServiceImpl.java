package com.dio.santanderdev2023.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santanderdev2023.domain.model.User;
import com.dio.santanderdev2023.domain.repositories.UserRepository;
import com.dio.santanderdev2023.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User obj) {
		if(repository.existsByAccountNumber(obj.getAccount().getNumber())) {
			throw new IllegalArgumentException("Este número da conta já existe");
		}
		return repository.save(obj);
	}

}
