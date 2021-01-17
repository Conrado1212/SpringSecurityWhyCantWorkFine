package pl.edu.wszib.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.IGroupVehicleDAO;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.dao.impl.GroupVehicleDAOImpl;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.dao.impl.VehicleDAOImpl;
import pl.edu.wszib.service.IAuthenticationService;
import pl.edu.wszib.service.IGroupVehicleService;
import pl.edu.wszib.service.IUserService;
import pl.edu.wszib.service.IVehicleService;
import pl.edu.wszib.service.impl.AuthenticationServiceImpl;
import pl.edu.wszib.service.impl.GroupServiceImpl;
import pl.edu.wszib.service.impl.UserServiceImpl;
import pl.edu.wszib.service.impl.VehicleServiceImpl;

@Configuration
public class AppConfiguration {
    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }

    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
    @Bean
    public IVehicleDAO vehicleDAO(SessionFactory hibernateSessionFactory){
        return  new VehicleDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IVehicleService vehicleService(IVehicleDAO vehicleDAO){
        return new VehicleServiceImpl(vehicleDAO);
    }

    @Bean
    public IGroupVehicleDAO groupVehicleDAO(SessionFactory hibernateSessionFactory){
        return  new GroupVehicleDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IGroupVehicleService groupVehicleService(IGroupVehicleDAO groupVehicleDAO){
        return new GroupServiceImpl(groupVehicleDAO);
    }

    @Bean
    public IUserDAO userDAO(SessionFactory hibernateSessionFactory){
        return  new UserDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IAuthenticationService authenticationService(IUserDAO userDAO){
        return new AuthenticationServiceImpl(userDAO);
    }

    @Bean
    public IUserService userService(IUserDAO userDAO){
        return new UserServiceImpl(userDAO);
    }
}
