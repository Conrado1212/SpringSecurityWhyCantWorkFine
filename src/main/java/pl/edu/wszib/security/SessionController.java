package pl.edu.wszib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.wszib.dao.impl.UserDAOImpl;

@Controller
public class SessionController {

    @Autowired
    UserDAOImpl userDAO;

    public SessionController(UserDAOImpl userDAO){
        this.userDAO = userDAO;
    }
}
