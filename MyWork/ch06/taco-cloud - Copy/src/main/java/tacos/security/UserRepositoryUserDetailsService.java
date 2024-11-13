package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tacos.User;
import tacos.data.UserRepository;

@Service  // Marks this class as a Spring service, meaning it's a business/service layer bean
public class UserRepositoryUserDetailsService
        implements UserDetailsService {  // Implements Spring Security's UserDetailsService interface

  private UserRepository userRepo;  // Repository for interacting with User data in the database

  @Autowired  // Constructor injection to automatically wire the UserRepository dependency
  public UserRepositoryUserDetailsService(UserRepository userRepo) {
    this.userRepo = userRepo;  // Assigns the injected UserRepository to the class variable
  }

  @Override
  public UserDetails loadUserByUsername(String username)
          throws UsernameNotFoundException {
    // Looks up the user by their username in the repository
    User user = userRepo.findByUsername(username);
    if (user != null) {
      return user;  // If user found, returns the User object (which implements UserDetails)
    }
    // If user is not found, throws UsernameNotFoundException to indicate failure
    throw new UsernameNotFoundException(
            "User '" + username + "' not found");
  }

}
