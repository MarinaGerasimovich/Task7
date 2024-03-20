package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(User user) {
    entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
