package pl.edu.wszib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.dao.IGroupVehicleDAO;
import pl.edu.wszib.model.GroupVehicle;
import pl.edu.wszib.service.IGroupVehicleService;

@Service
public class GroupServiceImpl implements IGroupVehicleService {

    @Autowired
    IGroupVehicleDAO groupVehicleDAO;


    public GroupServiceImpl(IGroupVehicleDAO groupVehicleDAO){
        this.groupVehicleDAO = groupVehicleDAO;
    }


    @Override
    public void addGroupVehicle(GroupVehicle groupVehicle){
        GroupVehicle GroupVehicleFromDb = this.groupVehicleDAO.getGroupVehicle(groupVehicle.getIdGroupVehicle());
        if(GroupVehicleFromDb == null){
            this.groupVehicleDAO.addGroupVehicle(groupVehicle);
        }
    }


    @Override
    public GroupVehicle getGroupVehicle(int idGroupVehicle){
        return this.groupVehicleDAO.getGroupVehicle(idGroupVehicle);
    }


    @Override
    public void removeVehicleId(int idGroupVehicle){
        GroupVehicle groupVehicleFromDb = this.groupVehicleDAO.removeGroupVehicleId(idGroupVehicle);
        if(groupVehicleFromDb == null){
            this.groupVehicleDAO.removeGroupVehicleId(idGroupVehicle);
        }
    }



}
