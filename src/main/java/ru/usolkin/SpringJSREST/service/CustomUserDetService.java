package ru.usolkin.SpringJSREST.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.usolkin.SpringJSREST.dao.UserDao;
import ru.usolkin.SpringJSREST.model.User;


import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class CustomUserDetService implements UserDetailsService {
    private UserDao userDao;

    public CustomUserDetService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDao.getUserByName(username);
      if(user.isEmpty()) {
          throw new UsernameNotFoundException("Username not found");
      }
      return user.get();
    }
}
