package com.ironhack.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StudentChecking extends Account{

    private final BigDecimal penaltyFee = new BigDecimal("40");


    //CONSTRUCTORES

    public StudentChecking(int secretKey, Holder primaryOwner, Holder secondOwner) {
        super(secretKey, primaryOwner, secondOwner);
    }



    public StudentChecking(){

    }


    //GETTERS & SETTERS

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }
}
