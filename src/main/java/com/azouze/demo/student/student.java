package com.azouze.demo.student;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Entity
@Table
public class student {
    @Id
    @GeneratedValue
    public long id;
    @Setter
    private String name;
    private String email;
    private LocalDate birthday;
    @Transient
    private int age;


    public student() {

    }


    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public student(String name, String email, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
