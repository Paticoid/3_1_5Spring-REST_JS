package ru.usolkin.SpringJSREST.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.usolkin.SpringJSREST.dao.RoleDao;
import ru.usolkin.SpringJSREST.dao.UserDao;
import ru.usolkin.SpringJSREST.model.Role;
import ru.usolkin.SpringJSREST.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;
    private final RoleDao roleDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDAO, RoleDao roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDAO.allUsers();
    }

    @Override
    public User getById(long id) {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(passwordCoder(user));
    }

    @Override
    public void update(long id,User user) {
        userDAO.update(id,user);
    }

    @Override
    public void deleteById(long id) {
        userDAO.delete(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.getUserByName(username).get();
    }

}

