package com.mindtree.CMS.service;

import java.util.List;

import com.mindtree.CMS.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getUser(Long userId);

}
