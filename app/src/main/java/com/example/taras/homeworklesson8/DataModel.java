package com.example.taras.homeworklesson8;

import java.io.Serializable;

/**
 * Created by taras on 15.03.16.
 */
public class DataModel implements Serializable {
    String firstName, lastName, gender, age, phoneNumber, NA = "N/A";

    public DataModel(String firstName, String lastName, String gender, String age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isFilled() {
        if (lastName == NA) {
            return false;
        }

        if (gender == NA) {
            return false;
        }

        if (age == NA) {
            return false;
        }

        if (phoneNumber == NA) {
            return false;
        }
        
        return true;
    }
}
