package com.mindtree.CMS.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.CMS.dao.UserRepository;
import com.mindtree.CMS.model.User;
import com.mindtree.CMS.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll(false);
	}

	public User getUser(Long userId) {
		return userRepository.findByUserId(userId, false);
	}

}
