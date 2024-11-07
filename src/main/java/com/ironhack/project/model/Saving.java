package com.ironhack.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Saving extends Account{


    @NotNull
    @DecimalMin(value = "0.0025",inclusive = true)
    @DecimalMax(value = "0.5", inclusive = true)
    private BigDecimal interestRate;
    @NotNull
    @DecimalMin(value = "100",inclusive = true)
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal minBalance;

    private final BigDecimal penaltyFee = new BigDecimal("40");


    //CONSTRUCTORES

    public Saving(int secretKey, Holder primaryOwner, Holder secondOwner, BigDecimal interestRate, BigDecimal minBalance) {
        super(secretKey, primaryOwner, secondOwner);
        this.interestRate = interestRate;
        this.minBalance = minBalance;
    }

    public Saving(int secretKey, Holder primaryOwner, Holder secondOwner, BigDecimal minBalance) {
        super(secretKey, primaryOwner, secondOwner);
        this.interestRate = new BigDecimal(0.0025);
        this.minBalance = minBalance;
    }


    public Saving(int secretKey, Holder primaryOwner, Holder secondOwner) {
        super(secretKey, primaryOwner, secondOwner);
        this.interestRate = new BigDecimal(0.0025);
        this.minBalance = new BigDecimal(1000);
    }

    public Saving(int secretKey, Holder primaryOwner) {
        super(secretKey, primaryOwner);
        this.interestRate = new BigDecimal(0.0025);
        this.minBalance = new BigDecimal(1000);
    }



    public Saving() {

    }



    //GETTERS & SETTERS

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }
}
