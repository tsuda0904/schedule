package com.eightbit.schedule.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eightbit.schedule.entity.LoginUser;
import com.eightbit.schedule.entity.Role;
import com.eightbit.schedule.model.LoginUserDto;
import com.eightbit.schedule.repository.LoginUserRepository;

import jakarta.transaction.Transactional;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	private final LoginUserRepository loginUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public LoginUserDetailsService(LoginUserRepository loginUserRepository) {
		this.loginUserRepository = loginUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<LoginUser> loginUserOptional = Optional.of(loginUserRepository.findByEmail(email));
		return loginUserOptional.map(loginUser -> new LoginUserDetails(loginUser))
				.orElseThrow(() -> new UsernameNotFoundException("not found"));
	}
	
	public LoginUser findByEmail(String email) {
		return loginUserRepository.findByEmail(email);
	}
	
	@Transactional
	public void save(LoginUserDto loginUserDto) {
		LoginUser loginUser = new LoginUser();
		Role role = new Role();
		role.setId(1);
		
		loginUser.setName(loginUserDto.getName());
		loginUser.setEmail(loginUserDto.getEmail());
		loginUser.setPassword(passwordEncoder.encode(loginUserDto.getPassword()));
		loginUser.setRole(role);
		
		loginUserRepository.save(loginUser);
	}
}
