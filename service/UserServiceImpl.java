package com.sbsse.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sbsse.model.Role;
import com.sbsse.model.User;
import com.sbsse.repository.RoleRepository;
import com.sbsse.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private RoleRepository rr;
	
	/*
	 * Comparison
	 */
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	//
	
	@Override
	public User findUserByEmail(String email) {
		return ur.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bcpe.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = rr.findByRole("ADMIN");
		/*
		 * Az Array osztalynak van egy asList nevu statikus metodusa, ami
		 * egy tomb elemeit List-kent is elerhetove teszi. Ez a metodus nem
		 * masolja at a tomb elemeit, csupan referenciakkal dolgozik, es ugyanazok
		 * az elemek a listabol es a tombbol is elerhetoek.
		 */
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		ur.save(user);
	}

}
