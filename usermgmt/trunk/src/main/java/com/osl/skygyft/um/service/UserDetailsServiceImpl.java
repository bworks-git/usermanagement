package com.osl.skygyft.um.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.osl.skygyft.um.domain.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;
	
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException, DataAccessException {
		User user = userService.getByLogin(login);
		return user;
	}
}