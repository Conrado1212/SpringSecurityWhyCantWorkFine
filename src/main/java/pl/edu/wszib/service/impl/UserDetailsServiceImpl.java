package pl.edu.wszib.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.MyUserDetails;
import pl.edu.wszib.model.User;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserDAO userDAO;


    public UserDetailsServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userDAO.findByUsername(username);
        if(user == null){
            throw  new UsernameNotFoundException("User dont exist");
        }
        return new MyUserDetails(user);
    }
}
