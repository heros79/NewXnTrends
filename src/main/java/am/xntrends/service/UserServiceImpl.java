package am.xntrends.service;

import am.xntrends.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Service("User")
@Transactional
public class UserServiceImpl implements UserService {

    private EntityManager entityManager;

    public UserServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findById(Long id) {

        final String sql = "SELECT a FROM User a WHERE a.id = :id";

        TypedQuery<User> q = entityManager.createQuery(sql, User.class);

        User user;
        try {
            user = q.setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

}