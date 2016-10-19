package nl.hro.assignment2.models;


import org.apache.logging.log4j.core.Logger;
import org.apache.logging.slf4j.Log4jLogger;
import org.apache.logging.slf4j.Log4jLoggerFactory;

public class Position {

    private String name;
    private String discription;
    private double feePerHour;

    private String projectID;

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
            new Log4jLoggerFactory().getLogger("main").warn("Project given was null");
            return;
        }
        projectID = project.getUniqueId();
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
