package me.syus.ticketservice.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public abstract class CRUDRepositoryImpl<T, ID> implements CRUDRepository<T, ID> {

    protected Class<T> hQLEntityClazz;

    public abstract void setHQLEntityClazz();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T save(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.save(t);
        return t;
    }

    @Override
    public List<T> findAll() {
        String hql = "FROM " + hQLEntityClazz.getName();
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<T> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public T findById(ID id) {
        String hql = "FROM "+hQLEntityClazz.getName() +" t where t.id = :id";
        System.out.println("hql="+hql);
        TypedQuery<T> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id",id);
        return query.getSingleResult();
    }
}
