package pl.edu.wszib.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

public class Rent {
    private int idRent;
    private int idVehicle;
    private int idUser;
    private int idGroupVehicle;
    private double howLong;
     @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
     @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
     message="Must be formatted MM/YY")
    private String ccExpiration;
     @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;


    public int getIdRent() {
        return idRent;
    }

    public void setIdRent(int idRent) {
        this.idRent = idRent;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdGroupVehicle() {
        return idGroupVehicle;
    }

    public void setIdGroupVehicle(int idGroupVehicle) {
        this.idGroupVehicle = idGroupVehicle;
    }

    public double getHowLong() {
        return howLong;
    }

    public void setHowLong(double howLong) {
        this.howLong = howLong;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }
}
