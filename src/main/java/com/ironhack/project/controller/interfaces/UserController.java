package com.ironhack.project.controller.interfaces;

import com.ironhack.project.controller.dto.account.AccountBalanceDTO;
import com.ironhack.project.controller.dto.account.AccountDTO;
import com.ironhack.project.controller.dto.account.ResAccountDTO;
import com.ironhack.project.controller.dto.checking.CheckingDTO;
import com.ironhack.project.controller.dto.checking.ResCheckingAccountDTO;
import com.ironhack.project.controller.dto.creditcard.CreditCardDTO;
import com.ironhack.project.controller.dto.creditcard.ResCreditCardAccountDTO;
import com.ironhack.project.controller.dto.saving.ResSavingAccountDTO;
import com.ironhack.project.controller.dto.saving.SavingDTO;
import com.ironhack.project.controller.dto.student.ResStudentCheckingAccountDTO;
import com.ironhack.project.model.*;

import java.util.List;

public interface AdminController {

    //GET ALL ACCOUNTS BY TYPE
    List<Checking> allCheckingAccounts();
    List<StudentChecking> allStudentCheckingAccounts();
    List<Saving> allSavingAccounts();
    List<CreditCard> allCreditCardAccounts();


    //CREATE A HOLDER

    void createHolder(Holder holder);

    //CREATE ADMIN

    void createAdmin(User user);

    //CREATE THIRD PARTY

    void createThirdParty(ThirdParty thirdParty);

    //FIND ACCOUNTS
    Money getBalance(Long id);


    ResAccountDTO findAccountById(Long id);

    ResCheckingAccountDTO findCheckingById(Long id);
    ResStudentCheckingAccountDTO findStudentCheckingById(Long id);
    ResSavingAccountDTO findSavingById(Long id);
    ResCreditCardAccountDTO findCreditCardById(Long id);



    //CREATE ACCOUNTS

    Account createCheckingAccount(CheckingDTO checkingDTO);
    Account createSavingAccount(SavingDTO savingDTO);
    Account createCreditCardAccount(CreditCardDTO creditCardDTO);


    // UPDATING BALANCE

    void updateAccountBalance(Long id, AccountBalanceDTO accountBalanceDTO);

}
