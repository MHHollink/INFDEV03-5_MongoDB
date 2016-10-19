package nl.hro.assignment2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Headquarter {

    @Id
    private String name;

    private int rooms;
    private double rent;
    private Address address;

    @Version
    Long version;

    public Headquarter() {
    }

    public Headquarter(String name, int rooms, double rent, Address address) {
        this.name = name;
        this.rooms = rooms;
        this.rent = rent;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Headquarter{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                ", rent=" + rent +
                ", address=" + address +
                '}';
    }
}
