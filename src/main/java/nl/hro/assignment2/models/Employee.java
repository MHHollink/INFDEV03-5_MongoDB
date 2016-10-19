package nl.hro.assignment2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Employee {

    @Id
    private int bsn;

    private String name;
    private String surname;

    private List<Address> addresses;
    private List<Degree> degrees;

    @Version
    Long version;

    public Employee() {
        addresses = new ArrayList<>();
        degrees = new ArrayList<>();
    }

    public Employee(int bsn, String name, String surname) {
        this();
        this.bsn = bsn;
        this.name = name;
        this.surname = surname;
    }

    public Employee(int bsn, String name, String surname, List<Address> addresses, List<Degree> degrees) {
        this(bsn, name, surname);
        this.addresses = addresses;
        this.degrees = degrees;
    }

    public int getBsn() {
        return bsn;
    }

    public void setBsn(int bsn) {
        if(bsn <  99999999) //       must be at least 100 000 000
            return;
        if(bsn > 999999999) // can not be bigger then 999 999 999
            return;

        this.bsn = bsn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "bsn='" + bsn + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addresses=" + addresses +
                ", addresses=" + addresses +
                ", degrees=" + degrees +
                '}';
    }
}
