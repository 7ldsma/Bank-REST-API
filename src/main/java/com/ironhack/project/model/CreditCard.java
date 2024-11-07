package com.ironhack.project.model;

import com.ironhack.project.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Account{

    @NotNull
    @DecimalMin(value = "100", inclusive = true)
    @DecimalMax(value = "100000", inclusive = true)
    private BigDecimal creditLimit;
    @NotNull
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "0.2", inclusive = true)
    private BigDecimal interestRate;


    //CONSTRUCTORES

    public CreditCard(int secretKey, Holder primaryOwner, Holder secondOwner) {
        super(secretKey, primaryOwner, secondOwner);
        this.creditLimit = new BigDecimal(100);
        this.interestRate = new BigDecimal(0.2);
    }

    public CreditCard(int secretKey, Holder primaryOwner) {
        super(secretKey, primaryOwner);
        this.creditLimit = new BigDecimal(100);
        this.interestRate = new BigDecimal(0.2);
    }

    public CreditCard(int secretKey, Holder primaryOwner, Holder secondOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(secretKey, primaryOwner, secondOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public CreditCard(){

    }


    //GETTERS & SETTERS

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
