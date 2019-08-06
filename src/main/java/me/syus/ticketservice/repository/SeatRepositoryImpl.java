package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SeatRepositoryImpl extends CRUDRepositoryImpl<Seat, Long>  implements SeatRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Seat> findAvailable() {
        String hql = "FROM Seat s where s.availability = true";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Seat> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Autowired
    @Override
    public void setHQLEntityClazz() {
        this.hQLEntityClazz = Seat.class;
    }
}
