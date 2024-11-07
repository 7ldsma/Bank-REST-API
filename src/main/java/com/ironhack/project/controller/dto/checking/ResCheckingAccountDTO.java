package com.ironhack.project.controller.dto.checking;

import com.ironhack.project.enums.Status;
import com.ironhack.project.model.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResCheckingAccountDTO {

    private Long primaryOwnerId;
    private Long secondOwnerId;
    private Money balance;
    private BigDecimal minBalance;
    private BigDecimal mmFee;
    private LocalDate creationDate;
    private Status status;



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

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
