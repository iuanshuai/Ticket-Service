package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl extends CRUDRepositoryImpl<User, Long> implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        String hql = "FROM User";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<User> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        String hql = "FROM User u where u.id = :id";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id);
        return query.getSingleResult();
    }

    @Autowired
    @Override
    public void setHQLEntityClazz() {
        this.hQLEntityClazz = User.class;
    }

}
