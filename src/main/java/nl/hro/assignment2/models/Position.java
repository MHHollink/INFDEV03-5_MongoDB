package nl.hro.assignment2.models;


public class Position {

    private String name;
    private String discription;
    private double feePerHour;

    private String projectID;
    private int hours;

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

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(Project project) {
        if(project == null) {
            return;
        }
        projectID = project.getUniqueId();
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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
