package pl.edu.wszib.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.Vehicle;
import pl.edu.wszib.service.IAuthenticationService;

import javax.annotation.Resource;

@Controller
public class LoginController {


    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    IAuthenticationService authenticationService;

    public LoginController(){

    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public String mainSite(){
        return "redirect:login";
    }

   /* @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage( ) {
        return new ModelAndView("login", "loginKey", new User());
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginForm(@ModelAttribute("loginKey") User user){
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin") ){
            this.sessionObject.setUser(user);
            return "redirect:rentAppPage";
        }
        System.out.println(user);
        return "login";
    }

    */

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("userModel",new User());
        model.addAttribute("errorMessage","");
        return "login";
    }

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public  String authenticateUser(@ModelAttribute("userModel")User user,Model model){
        boolean authResult = this.authenticationService.authenticationUser(user);
        if(authResult){
            System.out.println("zalogowano !!");

            return "rentAppPage";
        }else{
            model.addAttribute("errorMessage","zle dane!!!");
            model.addAttribute("userModel",new User());
            return "login";
        }
    }

    @RequestMapping(value = "/rentAppPage", method = RequestMethod.GET)
    public String page(Model model) {
        if(this.sessionObject.getUser() == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", this.sessionObject.getUser().getUsername());
        return "rentAppPage";
    }

   /* @RequestMapping(value = "/rentAppPage",method = RequestMethod.GET)
    public ModelAndView rentAppPage(){
        return new ModelAndView("rentAppPage","rentKey",new Vehicle());
    }

    @RequestMapping(value = "/rentAppPage",method = RequestMethod.POST)
    public String rentForm(@ModelAttribute("rentKey") Vehicle vehicle){
        System.out.println(vehicle);
        return "rentAppPage";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "rentAppPage";
    }

    */




    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUser(null);
        return "redirect:login";
    }


}
