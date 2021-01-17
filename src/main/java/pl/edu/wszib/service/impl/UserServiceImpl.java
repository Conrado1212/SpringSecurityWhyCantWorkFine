package pl.edu.wszib.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public void registerUser(User user){
        User userFromDb = this.userDAO.findByUsername(user.getUsername());
        if(userFromDb == null){
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            this.userDAO.addUser(user);
        }
    }

    @Override
    public User getUserByLogin(String username){
        return this.userDAO.findByUsername(username);
    }

    @Override
    public List<User> getAllUser(){
        return this.userDAO.getAllUser();
    }
}
