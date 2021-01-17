package pl.edu.wszib.service;

import pl.edu.wszib.model.GroupVehicle;

public interface IGroupVehicleService {
    void addGroupVehicle(GroupVehicle groupVehicle);

    GroupVehicle getGroupVehicle(int idGroupVehicle);

    void removeVehicleId(int idGroupVehicle);
}
