package pl.edu.wszib.model;

import javax.persistence.*;

@Entity
@Table(name = "groupvehicle")
public class GroupVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroupVehicle;


    private double pricePerMinute;
    private String type;


    public GroupVehicle(){

    }




    public GroupVehicle(int idGroupVehicle, double pricePerMinute, String type) {
        this.idGroupVehicle = idGroupVehicle;
        this.pricePerMinute = pricePerMinute;
        this.type = type;
    }

    public int getIdGroupVehicle() {
        return idGroupVehicle;
    }

    public void setIdGroupVehicle(int idGroupVehicle) {
        this.idGroupVehicle = idGroupVehicle;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
