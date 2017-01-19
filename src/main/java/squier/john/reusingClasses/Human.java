package squier.john.reusingClasses;

import com.sun.tools.javac.jvm.Gen;

/**
 * Created by johnsquier on 1/18/17.
 */
public class Human {

    private String name;
    private Integer age;
    private Genders gender;
    private String occupation;
    private String address;

    public Human() {
        name = "default";
        age = 0;
        gender = Genders.MALE;
        occupation = "default";
        address = "default";
    }

    public Human(String name, Integer age, Genders gender, String occupation, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void printInformation() {
        System.out.printf("Name: %s\nAge: %d\nGender: %s\nOccupation: %s\nAddress: %s\n",
                name, age, gender.toString(), occupation, address);
    }
}
