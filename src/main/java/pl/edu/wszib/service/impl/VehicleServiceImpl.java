package pl.edu.wszib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IVehicleDAO;
import pl.edu.wszib.model.Vehicle;
import pl.edu.wszib.service.IVehicleService;

public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleDAO vehicleDAO;


    public VehicleServiceImpl(IVehicleDAO vehicleDAO){
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        Vehicle vehicleFromDb = this.vehicleDAO.getVehicle(vehicle.getIdVehicle());
        if(vehicleFromDb == null){
            this.vehicleDAO.addVehicle(vehicle);
        }
    }

    @Override
    public Vehicle getVehicle(int idVehicle){
        return this.vehicleDAO.getVehicle(idVehicle);
    }

    @Override
    public void getUpdate(int idVehicle, Vehicle vehicle){
        Vehicle vehicleFromDb = this.vehicleDAO.getUpdate(idVehicle, vehicle);
        if(vehicleFromDb == null){
            this.vehicleDAO.getUpdate(idVehicle, vehicle);
        }
    }

    @Override
    public void removeVehicleId(int idVehicle){
        Vehicle vehicleFromDb = this.vehicleDAO.removeVehicleId(idVehicle);
        if(vehicleFromDb == null){
            this.vehicleDAO.removeVehicleId(idVehicle);
        }
    }
}
