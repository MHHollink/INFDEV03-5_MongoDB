package nl.hro.assignment2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {

    @Id
    private String uniqueId;

    private double budget;
    private int totalAmountOfAllocatedHours;

    @Version
    Long version;

    public Project() {
    }

    public Project(String uniqueId, double budget, int totalAmountOfAllocatedHours) {
        this.uniqueId = uniqueId;
        this.budget = budget;
        this.totalAmountOfAllocatedHours = totalAmountOfAllocatedHours;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getTotalAmountOfAllocatedHours() {
        return totalAmountOfAllocatedHours;
    }

    public void setTotalAmountOfAllocatedHours(int totalAmountOfAllocatedHours) {
        this.totalAmountOfAllocatedHours = totalAmountOfAllocatedHours;
    }

    @Override
    public String toString() {
        return "Project{" +
                "uniqueId='" + uniqueId + '\'' +
                ", budget=" + budget +
                ", totalAmountOfAllocatedHours=" + totalAmountOfAllocatedHours +
                '}';
    }
}
