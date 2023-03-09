package com.backend.portfolio.Services;

import com.backend.portfolio.Models.Entities.registerEntity;
import com.backend.portfolio.Models.Repositories.loginRepo;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class loginService implements UserDetailsService {

  //autowired
  @Autowired
  private loginRepo loginRepo;

  public registerEntity loginUser(String username, String password) {
    if (username.isBlank() || password.isBlank()) {
      throw new RuntimeException("Username or password cannot be blank");
    }

    Optional<registerEntity> userOptional = loginRepo.findByUsernameAndPassword(
      username,
      password
    );
    if (userOptional.isPresent()) {
      return userOptional.get();
    } else {
      throw new RuntimeException("Invalid username or password");
    }
  }

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    Optional<registerEntity> userOptional = loginRepo.findByUsername(username);

    if (userOptional.isPresent()) {
      registerEntity user = userOptional.get();
      return new User(
        user.getUsername(),
        user.getPassword(),
        new ArrayList<>()
      );
    } else {
      throw new UsernameNotFoundException(
        "User not found with username: " + username
      );
    }
  }
}
