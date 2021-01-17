package pl.edu.wszib.service;

import pl.edu.wszib.model.Vehicle;

public interface IVehicleService {
    void addVehicle(Vehicle vehicle);

    Vehicle getVehicle(int idVehicle);

    void getUpdate(int idVehicle, Vehicle vehicle);

    void removeVehicleId(int idVehicle);
}
