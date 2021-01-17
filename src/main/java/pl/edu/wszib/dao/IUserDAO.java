package pl.edu.wszib.dao;

import pl.edu.wszib.model.User;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public interface IUserDAO {
    void addUser(User user);



    User findByUsername(String username);

    User getUserById(int idUser);

    List<User> getAllUser();

    Vehicle removeUserId(int idUser);

    User getUpdate(int idUser, User user);

    void getUpdateUser(int idUser, User user);

    void updateUser(int idUser, User user);
}
