package com.users.academyusers.entities;

import com.example.common.enums.users.Belts;
import com.example.common.enums.users.UserRole;
import com.example.common.enums.users.UserStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String rg;
    private String cpf;
    private LocalDate dateOfBirth;
    private Integer age;
    private BigDecimal weight;
    private BigDecimal height;
    private String address;
    private String cellphoneNumber;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Belts belts;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;


    public User() {
    }

    public User(String name, String rg, String cpf, LocalDate dateOfBirth, Integer age, BigDecimal weight, BigDecimal height, String address, String cellphoneNumber, String email, String password, Belts belts, UserRole userRole, UserStatus userStatus) {
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.address = address;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.password = password;
        this.belts = belts;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }
}
