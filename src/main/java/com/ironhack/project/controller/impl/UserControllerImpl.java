package com.ironhack.project.controller.impl;

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
import com.ironhack.project.controller.interfaces.AdminController;
import com.ironhack.project.model.*;
import com.ironhack.project.repository.*;
import com.ironhack.project.service.interfaces.AdminService;
import com.ironhack.project.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private SavingRepository savingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private AdminService adminService;




    //CREATE HOLDER

    @PostMapping("/holder")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHolder(@RequestBody @Valid Holder holder){
        adminService.createHolder(holder);
    }

    //CREATE ADMIN

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAdmin(@RequestBody @Valid User user){
        adminService.createAdmin(user);
    }

    //CREATE THIRD PARTY

    @PostMapping("/thirdParty")
    @ResponseStatus(HttpStatus.CREATED)
    public void createThirdParty(@RequestBody @Valid ThirdParty thirdParty){
        adminService.createThirdParty(thirdParty);
    }


    //GETTING ALL ACCOUNTS BY TYPE

    @GetMapping("/checking")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> allCheckingAccounts() {
        return checkingRepository.findAll();
    }

    @GetMapping("/studentChecking")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> allStudentCheckingAccounts() {
        return studentCheckingRepository.findAll();
    }

    @GetMapping("/accounts/saving")
    @ResponseStatus(HttpStatus.OK)
    public List<Saving> allSavingAccounts() {
        return savingRepository.findAll();
    }


    @GetMapping("/accounts/studentChecking")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> allCreditCardAccounts() {
        return creditCardRepository.findAll();
    }




    //GET ANY ACCOUNT BALANCE

    @GetMapping("/accounts/getBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable Long id){
        return adminService.getBalance(id);
    }


    //FIND ACCOUNT BY ID

    @GetMapping("/accounts/findAccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResAccountDTO findAccountById(@PathVariable Long id){
        return adminService.findAccountById(id);

    }


    @GetMapping("/accounts/checking/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResCheckingAccountDTO findCheckingById(@PathVariable Long id) {
        return adminService.findCheckingById(id);
    }

    @GetMapping("/accounts/studentChecking/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResStudentCheckingAccountDTO findStudentCheckingById(Long id) {
        return adminService.findStudentCheckingById(id);
    }

    @GetMapping("/accounts/saving/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResSavingAccountDTO findSavingById(Long id) {
        return adminService.findSavingById(id);
    }

    @GetMapping("/accounts/creditCard/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResCreditCardAccountDTO findCreditCardById(Long id) {
        return adminService.findCreditCardById(id);
    }


    //CREATING ACCOUNTS




    @PostMapping("/checkingAccount/")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCheckingAccount(@RequestBody @Valid CheckingDTO checkingDTO) {
       return adminService.createCheckingAccount(checkingDTO);
    }

    @PostMapping("/savingAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createSavingAccount(@RequestBody @Valid SavingDTO savingDTO) {
        return adminService.createSavingAccount(savingDTO);
    }

    @PostMapping("/creditCardAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCreditCardAccount(CreditCardDTO creditCardDTO) {
        return adminService.createCreditCardAccount(creditCardDTO);
    }



    //UPDATE BALANCE

    @PatchMapping("/accounts/updateBalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccountBalance(@PathVariable Long id,@RequestBody @Valid AccountBalanceDTO accountBalanceDTO) {
        adminService.updateAccountBalance(id, accountBalanceDTO);
    }


}
