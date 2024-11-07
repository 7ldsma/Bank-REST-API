package com.ironhack.project.controller.dto.creditcard;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreditCardDTO {

    @NotNull
    private Long primaryOwnerId;
    private Long secondOwnerId;
    @NotNull
    private int secretKey;
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "0.2", inclusive = true)
    private BigDecimal interestRate;
    @DecimalMin(value = "100", inclusive = true)
    @DecimalMax(value = "100000", inclusive = true)
    private BigDecimal creditLimit;


    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondOwnerId() {
        return secondOwnerId;
    }

    public void setSecondOwnerId(Long secondOwnerId) {
        this.secondOwnerId = secondOwnerId;
    }

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
