package pl.edu.wszib.dao;

import pl.edu.wszib.model.GroupVehicle;

import java.util.List;

public interface IGroupVehicleDAO {
    void addGroupVehicle(GroupVehicle groupVehicle);

    GroupVehicle removeGroupVehicleId(int idGroupVehicle);

    GroupVehicle getGroupVehicle(int idGroupVehicle);

    List<GroupVehicle> getPriceCar();


    List<GroupVehicle> getPriceMotorBike();

    List<GroupVehicle> getPriceBike();

    List<GroupVehicle> getPriceScooter();

    List<GroupVehicle> getPriceVehicle();
}
