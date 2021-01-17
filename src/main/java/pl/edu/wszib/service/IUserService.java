package pl.edu.wszib.service;

import pl.edu.wszib.model.User;

import java.util.List;

public interface IUserService {
    void registerUser(User user);

    User getUserByLogin(String username);

    List<User> getAllUser();
}
