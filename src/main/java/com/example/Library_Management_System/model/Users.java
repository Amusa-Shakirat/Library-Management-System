package com.example.Library_Management_System.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "library_users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min = 6, max = 15, message = "Full name can't be less than 6 characters and more than 15 characters")
    @Column(name = "full_name")
    private String fullName;

    @Min(value = 18, message = "Age can't be less than 18years")
    @Max(value = 70, message = "Age can't be more than 70")
    private int age;

    @Email(message = "Please enter a valid email address")
    private String email;

    private String address;


    public Users(){};

    public Users(String fullName, int age, String email, String address) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

