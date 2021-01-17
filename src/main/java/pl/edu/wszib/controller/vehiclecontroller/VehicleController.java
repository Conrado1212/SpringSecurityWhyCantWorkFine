package pl.edu.wszib.controller.vehiclecontroller;


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
import pl.edu.wszib.dao.impl.VehicleDAOImpl;
import pl.edu.wszib.model.Distance;
import pl.edu.wszib.model.Vehicle;

import javax.annotation.Resource;


@Controller
public class VehicleController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    VehicleDAOImpl vehicleDAO;



    @RequestMapping(value = "/addVehicle",method = RequestMethod.GET)
    public ModelAndView addVehicle(){
        return new ModelAndView("addVehicle","addVehicleKey",new Vehicle());
    }


    @RequestMapping(value = "/addVehicle",method = RequestMethod.POST)
    public String addVehicleForm(@ModelAttribute("addVehicleKey") Vehicle vehicle){
        vehicleDAO.addVehicle(vehicle);
        return  "addVehicle";
    }

  /*  @RequestMapping(value = "/getVehicle",method = RequestMethod.GET)
    public ModelAndView getVehicle(){
        return new ModelAndView("getVehicle","getVehicleKey",new Vehicle());
    }

    @RequestMapping(value = "/getVehicle",method = RequestMethod.POST)
    public String getVehicleForm(@ModelAttribute("getVehicleKey") Vehicle vehicle){
        vehicleDAO.getVehicle(vehicle.getIdVehicle());
        return "redirect:resultGet";
    }

   */

    @RequestMapping("/getVehicle")
    public String vehicle(Model model, Vehicle vehicle, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "getVehicle"; // powrót do formularza
        }
        Vehicle result =  vehicleDAO.getVehicle(vehicle.getIdVehicle());
        model.addAttribute("result", result);
        return "resultGet";

    }

    @GetMapping("/getVehicle")
    public String VehicleForm(Vehicle vehicle) {
        return "getVehicle";
    }

   /* @RequestMapping(value = "/resultGet",method = RequestMethod.GET)
    public String indexGetVehicle(Model model, Vehicle vehicle){
        model.addAttribute("resultGet",vehicleDAO.getID(1));
        return"resultGet";
    }

    */

    @RequestMapping(value = "/removeVehicle",method = RequestMethod.GET)
    public ModelAndView removeVehicleId(){
        return new ModelAndView("removeVehicle","removeVehicleIdKey",new Vehicle());
    }

    @RequestMapping(value = "/removeVehicle",method = RequestMethod.POST)
    public String removeVehicleForm(@ModelAttribute("removeVehicleIdKey") Vehicle vehicle){
        vehicleDAO.removeVehicleId(vehicle.getIdVehicle());
        return "removeVehicle";
    }

    @RequestMapping(value = "/updateVehicle",method = RequestMethod.GET)
    public ModelAndView updateVehicle(){
        return new ModelAndView("updateVehicle","updateVehicleKey",new Vehicle());
    }

    @RequestMapping(value = "/updateVehicle",method = RequestMethod.POST)
    public String updateVehicleForm(@ModelAttribute("updateVehicleKey") Vehicle vehicle){
        vehicleDAO.getUpdate(vehicle.getIdVehicle(),vehicle);
        return "updateVehicle";
    }

}
