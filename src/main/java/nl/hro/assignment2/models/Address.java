package nl.hro.assignment2.models;

/**
 * Created by marcel on 18-10-2016.
 */
public class Address {

    private String postalCode;
    private String country;
    private String city;
    private int number;

    private boolean isCurrent;

    public Address() {
    }

    public Address(String postalCode, String country, String city, int number) {
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
