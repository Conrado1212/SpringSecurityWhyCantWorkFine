package pl.edu.wszib.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.service.IAuthenticationService;

public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;


    public AuthenticationServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public boolean authenticationUser(User user){
        User userFromDb = this.userDAO.findByUsername(user.getUsername());
        return userFromDb != null && userFromDb.getPassword().equals(DigestUtils.md5Hex(user.getPassword()));
    }
}
