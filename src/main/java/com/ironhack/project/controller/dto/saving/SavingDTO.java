package com.ironhack.project.controller.dto.saving;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SavingDTO {

    @NotNull
    private Long primaryOwnerId;
    private Long secondOwnerId;
    @NotNull
    private int secretKey;

    @DecimalMin(value = "0.0025",inclusive = true)
    @DecimalMax(value = "0.5", inclusive = true)
    private BigDecimal interestRate;

    @DecimalMin(value = "100",inclusive = true)
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal minBalance;



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

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }
}
