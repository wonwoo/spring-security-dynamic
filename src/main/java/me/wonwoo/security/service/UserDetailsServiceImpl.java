package me.wonwoo.security.service;

import lombok.extern.slf4j.Slf4j;
import me.wonwoo.domain.User;
import me.wonwoo.domain.UserDetail;
import me.wonwoo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByusername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User doesn`t exist");
    }
    List<String> userRoles = user.getUserRoles()
      .stream()
      .map(userRole -> userRole.getRole().getRoleName())
      .collect(Collectors.toList());
    log.info("username : {} , role : {} : ",  username , userRoles);

    return new UserDetail(user, userRoles);
  }

}