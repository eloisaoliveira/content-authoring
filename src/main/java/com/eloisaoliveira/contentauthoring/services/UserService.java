package com.eloisaoliveira.contentauthoring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloisaoliveira.contentauthoring.domain.User;
import com.eloisaoliveira.contentauthoring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

}
