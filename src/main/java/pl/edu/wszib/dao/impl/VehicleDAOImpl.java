package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

@Repository
public class VehicleDAOImpl implements IVehicleDAO {

    @Autowired
    SessionFactory sessionFactory;


    public VehicleDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void addVehicle(Vehicle vehicle){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(vehicle);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Vehicle getVehicle(int idVehicle){
        Session session = this.sessionFactory.openSession();
        Vehicle vehicle =
                (Vehicle) session.createQuery("FROM pl.edu.wszib.model.Vehicle WHERE idVehicle = " + idVehicle).uniqueResult();
        session.close();
        System.out.println(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllScooter() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Vehicle> AllScooter =
                session.createQuery("FROM pl.edu.wszib.model.Vehicle Where idGroupVehicle = 1 ").list();
        session.close();
        return AllScooter;
    }


    @Override
    public List<Vehicle> getID(int idVehicle) {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Vehicle> allId =
                session.createQuery("FROM pl.edu.wszib.model.Vehicle WHERE idVehicle = " + idVehicle).list();
        session.close();
        return allId;
    }






    @Override
    public Vehicle getUpdate(int idVehicle, Vehicle vehicle){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(Vehicle.class,idVehicle);

            session.update(vehicle);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }

        return vehicle;
    }

    @Override
    public  void getUpdateVehicle(int idVehicle, Vehicle vehicle){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(Vehicle.class,idVehicle);
            session.saveOrUpdate(vehicle);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void updateVehicle(int idVehicle, Vehicle vehicle){
        Session session = null;
        Transaction tx = null;
        Vehicle vehicle1;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            vehicle1 = (Vehicle)session.load(Vehicle.class,idVehicle);

            if(!(vehicle.getIdGroupVehicle()==0)){
                vehicle1.setIdGroupVehicle(vehicle.getIdGroupVehicle());
            }
            if(!(vehicle.getBrand().equals(""))){
                vehicle1.setBrand(vehicle.getBrand());
            }
            if(!(vehicle.getModel().equals(""))){
                vehicle1.setModel(vehicle.getModel());
            }
            if(!(vehicle.getMaxRange()==0)){
                vehicle1.setMaxRange(vehicle.getMaxRange());
            }
            if(!(vehicle.getWeight()==0)){
                vehicle1.setWeight(vehicle.getWeight());
            }
            if(!(vehicle.getPricePerSale()==0)){
                vehicle1.setPricePerSale(vehicle.getPricePerSale());
            }
            if(!(vehicle.getMaxSpeed()==0)){
                vehicle1.setMaxSpeed(vehicle.getMaxSpeed());
            }
            if(!(vehicle.getLatitude()==0)){
                vehicle1.setLatitude(vehicle.getLatitude());
            }
            if(!(vehicle.getLongitude()==0)){
                vehicle1.setLongitude(vehicle.getLongitude());
            }
            if(!(vehicle.getLocationName().equals(""))){
                vehicle1.setLocationName(vehicle.getLocationName());
            }
            session.update(vehicle);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Vehicle removeVehicleId(int idVehicle){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Vehicle vehicle =
                    (Vehicle) session.get(Vehicle.class, idVehicle);
            session.delete(vehicle);
            tx.commit();

        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }



    @Override
    public List<Vehicle> getAllCars() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Vehicle> allCar =
                session.createQuery("FROM pl.edu.wszib.model.Vehicle Where idGroupVehicle = 2 ").list();
        session.close();
        return allCar;
    }


    @Override
    public List<Vehicle> getAllMotorBike() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Vehicle> AllMotorBike =
                session.createQuery("FROM pl.edu.wszib.model.Vehicle Where idGroupVehicle = 3 ").list();
        session.close();
        return AllMotorBike;
    }

    @Override
    public List<Vehicle> getAllBike() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Vehicle> AllBike =
                session.createQuery("FROM pl.edu.wszib.model.Vehicle Where idGroupVehicle = 4 ").list();
        session.close();
        return AllBike;
    }




}
