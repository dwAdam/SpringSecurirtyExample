package com.sbsse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbsse.model.User;

/*
 * Right click on the project >
 * Properties > 
 * Maven > 
 * Remove active profiles > pom.xml
 * And then add the Repo annotation
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	/*
	 * Lets define the repos for accessing the
	 * User and Role details from the database.
	 * We'll extend the repos from Spring Data
	 * JPA's JpaRepository interface.
	 */
	
	User findByEmail(String email);

}
