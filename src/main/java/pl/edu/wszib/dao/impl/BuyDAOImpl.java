package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.IBuyDAO;
import pl.edu.wszib.model.Buy;


@Repository
public class BuyDAOImpl implements IBuyDAO {

    @Autowired
    SessionFactory sessionFactory;

    public BuyDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void addBuy(Buy buy){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(buy);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
    }
}
