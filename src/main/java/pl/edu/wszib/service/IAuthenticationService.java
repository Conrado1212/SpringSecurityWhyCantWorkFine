package pl.edu.wszib.service;

import pl.edu.wszib.model.User;

public interface IAuthenticationService {
    boolean authenticationUser(User user);
}
