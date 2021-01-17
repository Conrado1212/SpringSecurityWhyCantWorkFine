package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.BuyDAOImpl;
import pl.edu.wszib.dao.impl.VehicleDAOImpl;
import pl.edu.wszib.model.Buy;
import pl.edu.wszib.model.Vehicle;

import javax.annotation.Resource;

@Controller
public class BuyController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;


    @Autowired
    VehicleDAOImpl vehicleDAO;
    @Autowired
    BuyDAOImpl buyDAO;


    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    public ModelAndView getVehicle(){
        return new ModelAndView("buy","getVehicleKey",new Vehicle());
    }

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public String getVehicleForm(@ModelAttribute("getVehicleKey") Vehicle vehicle){
        vehicleDAO.getVehicle(vehicle.getIdVehicle());
        return "redirect:buy2";
    }

    @RequestMapping(value = "/buy2",method = RequestMethod.GET)
    public ModelAndView buyVehicle(){
        return new ModelAndView("buy2","getBuyKey",new Buy());
    }


    @RequestMapping(value = "/buy2",method = RequestMethod.POST)
    public String addVehicleForm(@ModelAttribute("getBuyKey") Buy buy){
        buyDAO.addBuy(buy);
        return  "redirect:resultBuy";
    }

    @RequestMapping(value = "/resultBuy",method = RequestMethod.GET)
    public ModelAndView buyVehicleId(){
        return new ModelAndView("resultBuy","BuyKey",new Vehicle());
    }

    @RequestMapping(value = "/resultBuy",method = RequestMethod.POST)
    public String removeVehicleForm(@ModelAttribute("BuyKey") Vehicle vehicle){
        vehicleDAO.removeVehicleId(vehicle.getIdVehicle());
        return "redirect:thanks";
    }

    @RequestMapping(value = "/thanks",method = RequestMethod.GET)
    public String indexGetVehicle(){

        return"thanks";
    }
}
