package model;

abstract public class Vehicle {
    String number;
    String type;
    int weight;
    int passengers;

    abstract public void parking(String number,String type);

    abstract public void leaveParking(String number,String type);

    abstract public String parkingSlot(String number,String type);

}


