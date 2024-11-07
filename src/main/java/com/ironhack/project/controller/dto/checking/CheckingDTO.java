package com.ironhack.project.controller.dto.checking;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CheckingDTO {

    @NotNull
    private Long primaryOwnerId;
    private Long secondOwnerId;
    @NotNull
    private int secretKey;




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
}
