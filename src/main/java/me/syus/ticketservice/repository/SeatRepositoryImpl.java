package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SeatRepositoryImpl extends CRUDRepositoryImpl<Seat, Long> implements SeatRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;


    @Override
    public List<Seat> findAllAvailableSeats() {
        String hql = "FROM Seat s where s.availability = 0";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Seat> query = s.createQuery(hql);
        return query.getResultList();
    }



    @Override
    public Seat save(Seat seat) {
        Session session = sessionFactory.getCurrentSession();
        session.save(seat);
        return seat;
    }

    @Override
    public Seat update(Seat seat) {
        Session session = sessionFactory.getCurrentSession();
        session.update(seat);
        return seat;
    }

    @Override
    public List<Seat> findAll() {
        String hql = "FROM Seat";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Seat> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Seat findById(Long id) {
        String hql = "FROM Seat seat where seat.id = :id";
        TypedQuery<Seat> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Seat> findByUser(Long id) {
        String hql = "FROM Seat seat where seat.user.id = :id";
        TypedQuery<Seat> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id);
        return query.getResultList();
    }

    @Autowired
    @Override
    public void setHQLEntityClazz() {
        this.hQLEntityClazz = Seat.class;
    }


}
