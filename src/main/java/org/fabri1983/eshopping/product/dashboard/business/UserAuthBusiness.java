package org.fabri1983.eshopping.product.dashboard.business;

import java.util.List;
import java.util.stream.Collectors;

import org.fabri1983.eshopping.product.dashboard.business.contract.UserAuthBusinessContract;
import org.fabri1983.eshopping.product.dashboard.model.UserAuth;
import org.fabri1983.eshopping.product.dashboard.repository.contract.UserAuthRepositoryContract;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserAuthBusiness implements UserAuthBusinessContract {

	private UserAuthRepositoryContract userAuthRepository;
	
	public UserAuthBusiness(UserAuthRepositoryContract userAuthRepository) {
		this.userAuthRepository = userAuthRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAuth user = userAuthRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
		}

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map( role -> new SimpleGrantedAuthority(role.getRoleName()) )
				.collect( Collectors.toList() );

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), authorities);

		return userDetails;
	}

}
