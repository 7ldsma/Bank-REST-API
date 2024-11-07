package com.ironhack.project.service.interfaces;

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

public interface AdminService {


    Holder createHolder(Holder holder);

    User createAdmin(User user);

    ThirdParty createThirdParty(ThirdParty thirdParty);


    Money getBalance(Long id);


    ResAccountDTO findAccountById(Long id);


    ResCheckingAccountDTO findCheckingById(Long id);
    ResStudentCheckingAccountDTO findStudentCheckingById(Long id);
    ResSavingAccountDTO findSavingById(Long id);
    ResCreditCardAccountDTO findCreditCardById(Long id);



    Account createCheckingAccount(CheckingDTO checkingDTO);
    Account createSavingAccount(SavingDTO savingDTO);
    Account createCreditCardAccount(CreditCardDTO creditCardDTO);



    void updateAccountBalance(Long id, AccountBalanceDTO accountBalanceDTO);

}
