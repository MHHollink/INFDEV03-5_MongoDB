package nl.hro.assignment2.utils;

import nl.hro.assignment2.models.Address;
import nl.hro.assignment2.models.Degree;
import nl.hro.assignment2.models.Employee;
import nl.hro.assignment2.models.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class RandomGenerator {

    private String[] fname = {
            "Marg", "Louella", "Corie", "Lavenia", "Valery", "Merrill", "Merrie", "Waneta", "Ela", "Abraham", "Layla", "Lashanda",
            "Delilah", "Kit", "Lizzie", "Kiesha", "Irvin", "Tran", "Mercedez", "Kerry", "Calvin", "Berry", "Tori", "Marvis", "Sina",
            "Jessie", "Lauryn", "Racheal", "Fernanda", "Emogene", "Alexander","Vennie", "Cherryl", "Gertudis", "Vaughn", "jewel",
            "Jeffery", "Marisa", "Delisa", "Francesca", "Elena", "Carma", "Emmaline", "Sherize", "Rosemary", "Lavern", "Suanne",
            "Deshawn", "Angelina", "Moon"
    };

    private String[] tween = {
            "aan ", "bij ", "de ", "den ", "der ", "in ", "het ", "'t ", "in het ", "in 't ", "in der ", "van der ", "van ", "van het ", "vanden "
    };

    private String[] lname = {
            "Mele", "Lema", "Carra", "Leigh", "Villanueva", "Mcgloth", "Mahood", "Welch", "Eckenrode","Avey", "Laing", "Licon",
            "Dudley", "Kamp", "Lynde", "Klassen", "Indelico", "Tufts", "Martines", "Kirksey", "Cavender", "Bozell", "Turnipseed",
            "Matteson", "Saez", "Jimmerson", "Lamere", "Ramirez", "Furness", "Ennals", "Austell", "Van", "Combs", "Gulino", "Vesely",
            "Joye", "Joshua", "Melgar", "Dickinson","Fisch", "Ebinger", "Stanley", "Rasmussen","Lenart", "Scholl", "Drone", "Avalos",
            "Valerius", "Victoria", "Moon"
    };

    private String[] country = {
            "Afghanistan", "Argentina", "Belgium", "Bosnia and Herzegovina", "Canada", "China", "Denmark", "Finland", "France",
            "Germany", "Italy", "Malawi", "Netherlands", "Russia",
    };

    private String[] school = {
            "HRO", "InHolland", "LOI", "HAN", "HKU",
    };

    private String[] level = {
            "Bachelor", "Master of Science", "PHD"
    };

    private Random random;

    public RandomGenerator(long seed) {
        random = new Random(seed);
    }

    public RandomGenerator() {
        random = new Random();
    }


    /// EMPLOYEE

    private String firstName() {
        return fname[random.nextInt(fname.length)];
    }

    private String lastName(){
        return random.nextBoolean() ?
                tween[random.nextInt(tween.length)] + lname[random.nextInt(lname.length)] :
                lname[random.nextInt(lname.length)];
    }

    private int bsn() {
        return random.nextInt(100000000) + 100000000;
    }

    public Employee employee() {
        Employee randomEmployee = new Employee(bsn(), firstName(), lastName());

        List<Address> addressList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(6) + 1; i++) {
            Address a = address();
            if(i == 0) a.setCurrent(true);
            addressList.add(a);
        }
        randomEmployee.setAddresses(addressList);

        List<Degree> degreeList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3); i++) {
            degreeList.add(degree());
        }
        randomEmployee.setDegrees(degreeList);

        return randomEmployee;
    }


    /// ADDRESS

    private String postalCode() {
        String postalCode = String.valueOf(random.nextInt(8999)+1000);
        for (int i = 0; i < 2; i++)
            postalCode += (char) (65 + random.nextInt(26));
        return postalCode;
    }

    private String country() {
        return country[random.nextInt(country.length)];
    }

    private String city() {
        String name = "";
        for (int i = 0; i < random.nextInt(16) + 6; i++)
            name += (char) (65 + random.nextInt(26));
        return name;
    }

    @SuppressWarnings("WeakerAccess")
    public Address address() {
        return new Address(postalCode(), country(), city(), random.nextInt(14000)+1);
    }


    /// DEGREE

    private String course() {
        String name = "";
        for (int i = 0; i < random.nextInt(16) + 6; i++)
            name += (char) (65 + random.nextInt(26));
        return name;
    }

    private String school() {
        return school[random.nextInt(school.length)];
    }


    private String level() {
        return level[random.nextInt(level.length)];
    }

    @SuppressWarnings("WeakerAccess")
    public Degree degree() {
        return new Degree(course(), school(), level());
    }


    /// PROJECT

    private String projectID(){
        return UUID.randomUUID().toString();
    }

    private double budget(){
        return random.nextInt(19900000)+100000;
    }

    private int hours(){
        return random.nextInt(8*5*52);
    }

    public Project project(){
        return new Project(projectID(), budget(), hours());
    }

    /// POSITION




    /// HEADQUARTER




}
