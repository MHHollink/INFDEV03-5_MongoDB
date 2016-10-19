package nl.hro.assignment2.models;

/**
 * Created by marcel on 18-10-2016.
 */
public class Degree {

    private String course;
    private String school;
    private String level;

    public Degree() {
    }

    public Degree(String course, String school, String level) {
        this.course = course;
        this.school = school;
        this.level = level;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "course='" + course + '\'' +
                ", school='" + school + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
