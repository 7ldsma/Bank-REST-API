package com.ironhack.project.controller.dto.account;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ResAccountDTO {

    private Long primaryOwnerId;
    private Long secondOwnerId;
    private BigDecimal interestRate;
    private BigDecimal minBalance;
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

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
