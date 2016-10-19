package nl.hro.assignment2.models;


public class Position {

    private String name;
    private String discription;
    private double feePerHour;

    public Position() {
    }

    public Position(String name, String discription, double feePerHour) {
        this.name = name;
        this.discription = discription;
        this.feePerHour = feePerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getFeePerHour() {
        return feePerHour;
    }

    public void setFeePerHour(double feePerHour) {
        this.feePerHour = feePerHour;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", feePerHour=" + feePerHour +
                '}';
    }
}
