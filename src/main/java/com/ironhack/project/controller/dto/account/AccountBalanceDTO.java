package com.ironhack.project.controller.dto.account;

import com.ironhack.project.model.Money;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AccountBalanceDTO {

    @NotNull(message = "You must enter the new balance")
    private Money balance;

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
