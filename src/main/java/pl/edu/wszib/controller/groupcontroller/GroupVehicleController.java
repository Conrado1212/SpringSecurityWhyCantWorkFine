package pl.edu.wszib.controller.groupcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.GroupVehicleDAOImpl;

import javax.annotation.Resource;

@Controller
public class GroupVehicleController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    GroupVehicleDAOImpl groupVehicleDAO;


    @RequestMapping(value ="/price",method = RequestMethod.GET)
    public String allScooter(Model model){
        model.addAttribute("price",this.groupVehicleDAO.getPriceVehicle());
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "price";
    }
}
