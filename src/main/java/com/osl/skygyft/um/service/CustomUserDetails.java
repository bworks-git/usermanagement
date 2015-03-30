package com.osl.skygyft.um.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.osl.skygyft.um.domain.User;

public class CustomUserDetails extends
		org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public CustomUserDetails(User user,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getLoginId(), user.getPassword(), authorities);
		this.user = user;
	}

	public CustomUserDetails(User user, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getLoginId(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				authorities);
		this.user = user;
	}

	public UserDetails getUser() {
		return user;
	}
}