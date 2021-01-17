package pl.edu.wszib.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.model.User;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;


    @Autowired
    UserDAOImpl userDAO;


    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public ModelAndView addUser(){
        return new ModelAndView("addUser","addUserKey",new User());
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUserForm(@ModelAttribute("addUserKey") User user){
        userDAO.addUser(user);
        return  "addUser";
    }

    @RequestMapping(value ="/allUser",method = RequestMethod.GET)
    public String AllUsers(Model model){
        model.addAttribute("allUser",userDAO.getAllUser());
        return "allUser";
    }
/*
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public ModelAndView getUser(){
        return new ModelAndView("getUser","getUserKey",new User());
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public String getUserForm(@ModelAttribute("getUserKey") User user){
        userDAO.getUserById(user.getIdUser());
        return "getUser";
    }

 */

    @RequestMapping("/getUser")
    public String getUser(Model model, User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "getUser"; // powrót do formularza
        }
        User result =  userDAO.getUserById(user.getIdUser());
        model.addAttribute("result", result);
        return "resultGetUser";

    }

    @GetMapping("/getUser")
    public String getUserForm(User user) {
        return "getUser";
    }


    @RequestMapping("/user")
    public String user(Model model, User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "user"; // powrót do formularza
        }
        User result =  userDAO.findByUsername(user.getUsername());
        model.addAttribute("result", result);
        return "resultUser";

    }

    @GetMapping("/user")
    public String userForm(User user) {
        return "user";
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.GET)
    public ModelAndView removeUserId(){
        return new ModelAndView("removeUser","removeUserIdKey",new User());
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
    public String removeUserForm(@ModelAttribute("removeUserIdKey") User user){
        userDAO.removeUserId(user.getIdUser());
        return "removeUser";
    }


    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public ModelAndView updateVehicle(){
        return new ModelAndView("updateUser","updateUserKey",new User());
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateVehicleForm(@ModelAttribute("updateUserKey") User user){
        userDAO.getUpdate(user.getIdUser(),user);
        return "updateUser";
    }


}
