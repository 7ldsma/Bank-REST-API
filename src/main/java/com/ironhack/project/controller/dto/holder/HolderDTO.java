package com.ironhack.project.controller.dto.holder;

import com.ironhack.project.model.Account;
import com.ironhack.project.model.Address;
import com.ironhack.project.model.Role;

import java.time.LocalDate;
import java.util.List;

public class HolderDTO {


    private String name;

    private String username;

    private List<Role> roles;

    private List<Account> primaryAccounts;

    private List<Account> secondaryAccounts;

    private LocalDate birthDate;

    private Address primaryAddress;





}
