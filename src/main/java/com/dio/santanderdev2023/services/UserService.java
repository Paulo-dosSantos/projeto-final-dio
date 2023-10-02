package com.dio.santanderdev2023.services;

import com.dio.santanderdev2023.domain.model.User;

public interface UserService {
	
	User findById(Long id);
	
	User create(User obj);

}
