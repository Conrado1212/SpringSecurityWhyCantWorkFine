package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public User findByUsername(String username) {
        Session  session = this.sessionFactory.openSession();
        User user =(User) session.createQuery("FROM pl.edu.wszib.model.User WHERE username = :username" )
                .setParameter("username", username)
                .uniqueResult();
        session.close();
        return user;

    }

    @Override
    public User getUserById(int idUser) {
        Session  session = this.sessionFactory.openSession();
        User user =(User) session.createQuery("FROM pl.edu.wszib.model.User WHERE idUser = " + idUser ).uniqueResult();
        session.close();
        return user;

    }


    @Override
    public List<User> getAllUser() {
        Session  session = this.sessionFactory.openSession();
        List <User>  users = session.createQuery("FROM pl.edu.wszib.model.User").list();
        session.close();
        return users;
    }

    @Override
    public Vehicle removeUserId(int idUser){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            User user =
                    (User) session.get(User.class, idUser);
            session.delete(user);
            tx.commit();

        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public User getUpdate(int idUser, User user){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(User.class,idUser);

            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public  void getUpdateUser(int idUser, User user) {
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(User.class,idUser);
            session.saveOrUpdate(user);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void updateUser(int idUser, User user) {
        Session session = null;
        Transaction tx = null;
        User user1;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            user1 = (User)session.load(User.class,idUser);

            if(!(user.getUsername().equals(""))){
                user1.setUsername(user.getUsername());
            }
            if(!(user.getPassword().equals(""))){
                user1.setPassword(user.getPassword());
            }
            if(!(user.getName().equals(""))){
                user1.setName(user.getName());
            }
            if(!(user.getSurname().equals(""))){
                user1.setSurname(user.getSurname());
            }
            if(!(user.getEmail().equals(""))){
                user1.setEmail(user.getEmail());
            }


            if(!(user.getLatitude()==0)){
                user1.setLatitude(user.getLatitude());
            }
            if(!(user.getLongitude()==0)){
                user1.setLongitude(user.getLongitude());
            }
            if(!(user.getRole().equals(""))){
                user1.setRole(user.getRole());
            }
            if(!(user.getLocationName().equals(""))){
                user1.setLocationName(user.getLocationName());
            }
            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }

}
