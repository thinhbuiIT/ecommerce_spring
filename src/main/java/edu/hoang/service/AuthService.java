package edu.hoang.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.hoang.DAO.AccountDAO;
import edu.hoang.entity.Account;
import edu.hoang.entity.Authority;
import edu.hoang.service.lmpl.AuthServiceImpl;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	public BCryptPasswordEncoder encoder;

	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private AuthServiceImpl authDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> optional = accountDao.findById(username);
		try {
			if (!optional.isEmpty()) {
				Account entity = optional.get();
				Set<Authority> authorities = authDAO.findByAccount(entity);
				String[] roles = authorities.stream()
						.map(auth -> auth.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				// Create user detail
				return User.withUsername(entity.getUsername())
						.password(encoder.encode(entity.getPassword()))
						.roles(roles).build();
			}
		} catch (UsernameNotFoundException e) {
			throw e;
		}
		return null;
	}

}
