package com.ironhack.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Holder extends User{

    @OneToMany(mappedBy = "primaryOwner")
    private List<Account> primaryAccounts;
    @OneToMany(mappedBy = "secondOwner")
    private List<Account> secondaryAccounts;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    @Embedded
    private Address primaryAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postal"))
             })
    @Embedded
    private Address mailingAddress;



    //CONSTRUCTORS

    public Holder(String name, String username, String password, LocalDate birthDate, Address primaryAddress) {
        super(name, username, password);
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
    }

    public Holder(String name, String username, String password, LocalDate birthDate, Address primaryAddress, Address mailingAddress) {
        super(name, username, password);
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }



    public Holder() {
    }




    //GETTERS & SETTERS



    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getPrimaryAccounts() {
        return primaryAccounts;
    }

    public void setPrimaryAccounts(List<Account> primaryAccounts) {
        this.primaryAccounts = primaryAccounts;
    }

    public List<Account> getSecondaryAccounts() {
        return secondaryAccounts;
    }

    public void setSecondaryAccounts(List<Account> secondaryAccounts) {
        this.secondaryAccounts = secondaryAccounts;
    }
}
