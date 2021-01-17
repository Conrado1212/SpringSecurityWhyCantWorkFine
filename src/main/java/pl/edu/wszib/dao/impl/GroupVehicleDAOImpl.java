package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.IGroupVehicleDAO;
import pl.edu.wszib.model.GroupVehicle;

import java.util.List;

@Repository
public class GroupVehicleDAOImpl implements IGroupVehicleDAO {

    @Autowired
    SessionFactory sessionFactory;

    public GroupVehicleDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGroupVehicle(GroupVehicle groupVehicle){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(groupVehicle);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public GroupVehicle removeGroupVehicleId(int idGroupVehicle){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            GroupVehicle groupVehicle =
                    (GroupVehicle) session.get(GroupVehicle.class, idGroupVehicle);
            session.delete(groupVehicle);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }


    @Override
    public GroupVehicle getGroupVehicle(int idGroupVehicle){
        Session session = this.sessionFactory.openSession();
        GroupVehicle groupVehicle =
                (GroupVehicle) session.createQuery("FROM pl.edu.wszib.model.GroupVehicle WHERE idGroupVehicle = " + idGroupVehicle).uniqueResult();

        session.close();
        return groupVehicle;
    }







    @Override
    public List<GroupVehicle> getPriceCar() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<GroupVehicle> priceCar = session.createQuery("FROM pl.edu.wszib.model.GroupVehicle Where idGroupVehicle = 1 ").list();
        session.close();
        return priceCar;
    }

    @Override
    public List<GroupVehicle> getPriceMotorBike() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<GroupVehicle> priceMotorBike = session.createQuery("FROM pl.edu.wszib.model.GroupVehicle Where idGroupVehicle = 2 ").list();
        session.close();
        return priceMotorBike;
    }

    @Override
    public List<GroupVehicle> getPriceBike() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<GroupVehicle> priceBike = session.createQuery("FROM pl.edu.wszib.model.GroupVehicle Where idGroupVehicle = 3 ").list();
        session.close();
        return priceBike;
    }


    @Override
    public List<GroupVehicle> getPriceScooter() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<GroupVehicle> priceScooter = session.createQuery("FROM pl.edu.wszib.model.GroupVehicle Where idGroupVehicle = 4 ").list();
        session.close();
        return priceScooter;
    }

    @Override
    public List<GroupVehicle> getPriceVehicle() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<GroupVehicle> price = session.createQuery("FROM pl.edu.wszib.model.GroupVehicle  ").list();
        session.close();
        return price;
    }
}
