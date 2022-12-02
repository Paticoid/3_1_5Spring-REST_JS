package ru.usolkin.SpringJSREST.service;



import ru.usolkin.SpringJSREST.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll ();
    User getById(long id);
    public User passwordCoder(User user);
    void save(User user);
    void deleteById(long id);
    User findByUsername(String username);
//    void addDefaultUser();
    void update(User user);

}
