package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.Seat;
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

    @Override
    public List<Seat> findAvailable() {
        String hql = "FROM Seat s where s.availability = true";
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

    @Autowired
    @Override
    public void setHQLEntityClazz() {
        this.hQLEntityClazz = Seat.class;
    }


}
