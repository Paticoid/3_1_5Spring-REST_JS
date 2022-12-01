package ru.usolkin.SpringJSREST.dao;

import org.springframework.stereotype.Repository;
import ru.usolkin.SpringJSREST.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return  entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles").getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class,id);

    }
    @Override
    public Optional<User> getUserByName(String name) {
        Query query= entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :user");
        query.setParameter("user", name);
        Optional<User> user = query.getResultStream().findAny();
        user.orElse(null);
        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    public void update(long id, User updateUser) {
        User user = entityManager.find(User.class,id);
        user.setPassword(updateUser.getPassword());
        user.setSurname(updateUser.getSurname());
        user.setUsername(updateUser.getUsername());
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setEmail(updateUser.getEmail());
        user.setRoles(updateUser.getRoles());
//        entityManager.merge(updateUser);

    }
    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User WHERE userId=?1").setParameter(1,id).executeUpdate();

    }
}
