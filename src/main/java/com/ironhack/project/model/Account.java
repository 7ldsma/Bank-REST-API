package com.ironhack.project.model;

import com.ironhack.project.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int secretKey;
    @Embedded
    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primaryOwnerId")
    private Holder primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondOwnerId")
    private Holder secondOwner;

    private LocalDate creationDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Status status;




    //CONSTRUCTORES

    public Account() {
    }

    public Account(int secretKey, Holder primaryOwner, Holder secondOwner) {
        this.secretKey = secretKey;
        this.balance = new Money(new BigDecimal(0));
        this.primaryOwner = primaryOwner;
        this.secondOwner = secondOwner;
        this.status = Status.ACTIVE;
    }

    public Account(int secretKey, Holder primaryOwner) {
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.balance = new Money(new BigDecimal(0));
        this.status = Status.ACTIVE;
    }




    //GETTERS & SETTERS

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Holder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Holder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Holder getSecondOwner() {
        return secondOwner;
    }

    public void setSecondOwner(Holder secondOwner) {
        this.secondOwner = secondOwner;
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
