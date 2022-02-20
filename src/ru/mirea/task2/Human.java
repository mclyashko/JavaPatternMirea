package ru.mirea.task2;

import java.time.LocalDate;

public class Human {
    private final int age;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public Human(int age) {
        this.age = age;
        this.firstName = null;
        this.lastName = null;
        this.birthDate = null;
        this.weight = 0;
    }

    public int getAge() {
        return age;
    }

// --Commented out by Inspection START (20.02.2022, 20:52):
//    public String getFirstName() {
//        return firstName;
//    }
// --Commented out by Inspection STOP (20.02.2022, 20:52)

    public String getLastName() {
        return lastName;
    }

// --Commented out by Inspection START (20.02.2022, 20:52):
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
// --Commented out by Inspection STOP (20.02.2022, 20:52)

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}
