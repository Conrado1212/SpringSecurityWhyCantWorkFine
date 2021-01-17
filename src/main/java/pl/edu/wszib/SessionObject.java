package pl.edu.wszib;

import pl.edu.wszib.model.User;

import java.util.List;

public class SessionObject {
    private User user = null;
    List<Object> products;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
