package pl.edu.wszib.dao;

import pl.edu.wszib.model.Vehicle;

import java.util.List;

public interface IVehicleDAO {


    void addVehicle(Vehicle vehicle);

    Vehicle getVehicle(int idVehicle);

    List<Vehicle> getID(int idVehicle);

    Vehicle getUpdate(int idVehicle, Vehicle vehicle);

    void getUpdateVehicle(int idVehicle, Vehicle vehicle);

    void updateVehicle(int idVehicle, Vehicle vehicle);

    Vehicle removeVehicleId(int idVehicle);

    List<Vehicle> getAllCars();

    List<Vehicle> getAllMotorBike();

    List<Vehicle> getAllBike();

    List<Vehicle> getAllScooter();
}
