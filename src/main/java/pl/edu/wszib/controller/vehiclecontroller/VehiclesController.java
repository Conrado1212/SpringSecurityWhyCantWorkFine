package pl.edu.wszib.controller.vehiclecontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.VehicleDAOImpl;

import javax.annotation.Resource;

@Controller
public class VehiclesController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    VehicleDAOImpl vehicleDAO;

    @RequestMapping(value ="/allCar",method = RequestMethod.GET)
    public String AllCars(Model model){
        model.addAttribute("allCar",vehicleDAO.getAllCars());
        return "allCar";
    }

    @RequestMapping(value = "/allMotorBike",method = RequestMethod.GET)
    public String allMotorBike(Model model){
        model.addAttribute("allMotorBike",vehicleDAO.getAllMotorBike());
        return"allMotorBike";
    }


    @RequestMapping(value = "/allBike",method = RequestMethod.GET)
    public String allBike(Model model){
        model.addAttribute("allBike",vehicleDAO.getAllBike());
        return "allBike";
    }

    @RequestMapping(value = "/allScooter",method = RequestMethod.GET)
    public String allScooter(Model model){
        model.addAttribute("allScooter",vehicleDAO.getAllScooter());
        return "allScooter";
    }
}
