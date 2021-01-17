package pl.edu.wszib.service.impl;


import org.springframework.stereotype.Service;
import pl.edu.wszib.service.IRentService;

@Service
public class RentServiceImpl implements IRentService {


    @Override
    public double price(int idGroupVehicle,double howLong){
        double pricePerMinute = 0;
        double price = 0;
        if(idGroupVehicle == 1) {
            pricePerMinute=0.5;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 2){
            pricePerMinute = 1;
            price= howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 3){
            pricePerMinute = 0.7;
            price = howLong * pricePerMinute;
            return price;
        }else if(idGroupVehicle == 4){
            pricePerMinute= 0.3;
            price = howLong * pricePerMinute;
            return price;
        }
        throw new IllegalArgumentException("Incorrect idGroupVehicle: " + idGroupVehicle);
    }

}
