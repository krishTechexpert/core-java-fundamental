package com.krish.securityProjectwithJPA.repo;

import com.krish.securityProjectwithJPA.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   @EntityGraph(attributePaths = "roles") // Fetch roles eagerly
   //✅ Why? This forces JPA to fetch roles along with User, preventing
      // lazy loading issues.
   Optional<User> findByUsername(String username);
}
