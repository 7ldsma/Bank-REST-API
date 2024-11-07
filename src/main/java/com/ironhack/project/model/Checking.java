package com.ironhack.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Checking extends Account{

    @NotNull(message = "Introduce a minimum balance")
    private BigDecimal minBalance;
    @NotNull(message = "Introduce a monthly maintenance fee")
    private BigDecimal mmFee;
    private final BigDecimal penaltyFee = new BigDecimal("40");



    //CONSTRUCTORS


    public Checking(int secretKey, Holder primaryOwner, Holder secondOwner) {
        super(secretKey, primaryOwner, secondOwner);
        this.minBalance = new BigDecimal(250);
        this.mmFee = new BigDecimal(12);
    }

    public Checking(int secretKey, Holder primaryOwner) {
        super(secretKey, primaryOwner);
        this.minBalance = new BigDecimal(250);
        this.mmFee = new BigDecimal(12);
    }

    public Checking() {

    }


    //GETTERS & SETTERS

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }

    public BigDecimal getMmFee() {
        return mmFee;
    }

    public void setMmFee(BigDecimal mmFee) {
        this.mmFee = mmFee;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }
}
