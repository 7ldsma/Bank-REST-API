package com.ironhack.project.service.impl;

import com.ironhack.project.controller.dto.account.AccountBalanceDTO;
import com.ironhack.project.controller.dto.account.ResAccountDTO;
import com.ironhack.project.controller.dto.checking.CheckingDTO;
import com.ironhack.project.controller.dto.checking.ResCheckingAccountDTO;
import com.ironhack.project.controller.dto.creditcard.CreditCardDTO;
import com.ironhack.project.controller.dto.creditcard.ResCreditCardAccountDTO;
import com.ironhack.project.controller.dto.holder.ResponseHolderDTO;
import com.ironhack.project.controller.dto.saving.ResSavingAccountDTO;
import com.ironhack.project.controller.dto.saving.SavingDTO;
import com.ironhack.project.controller.dto.student.ResStudentCheckingAccountDTO;
import com.ironhack.project.model.*;
import com.ironhack.project.repository.*;
import com.ironhack.project.service.interfaces.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository adminRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private SavingRepository savingRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private HolderRepository holderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;





    //CREATE HOLDER
    @Override
    public Holder createHolder(Holder holder){

        holder.setPassword(passwordEncoder.encode(holder.getPassword()));
        Role role = new Role("ACCOUNT_HOLDER");

        holder.setRoles(List.of(role));;
        return  holderRepository.save(holder);
    }

    //CREATE ADMIN


    public User createAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role("ADMIN");
        user.setRoles(List.of(role));
        return adminRepository.save(user);
    }


    //CREATE THIRD PARTY

    public ThirdParty createThirdParty(ThirdParty thirdParty){

        return thirdPartyRepository.save(thirdParty);
    }



    //GETTING AN ACCOUNT BALANCE

    @Override
    public Money getBalance(Long id){

        Optional<Checking> checkingOptional = checkingRepository.findById(id);
        Optional<StudentChecking> studentCheckingOptional = studentCheckingRepository.findById(id);
        Optional<Saving> savingOptional = savingRepository.findById(id);
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(id);

        if (checkingOptional.isPresent()){
            return checkingOptional.get().getBalance();

        } else if (studentCheckingOptional.isPresent()){
            return studentCheckingOptional.get().getBalance();

        } else if (savingOptional.isPresent()){
            return savingOptional.get().getBalance();

        } else if(creditCardOptional.isPresent()) {
            return creditCardOptional.get().getBalance();

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The account doesn't exist");

        }
    }



    // GETTING AN ACCOUNT


    @Override
    public ResAccountDTO findAccountById(Long id){
        
        Optional<Checking> checkingOptional = checkingRepository.findById(id);
        Optional<StudentChecking> studentCheckingOptional = studentCheckingRepository.findById(id);
        Optional<Saving> savingOptional = savingRepository.findById(id);
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(id);

        if (checkingOptional.isPresent()){
            Checking checking = checkingRepository.findById(id).get();

            return this.modelMapper.map(checking, ResAccountDTO.class);

        } else if (studentCheckingOptional.isPresent()){
            StudentChecking studentChecking = studentCheckingRepository.findById(id).get();

            return this.modelMapper.map(studentChecking, ResAccountDTO.class);

        } else if (savingOptional.isPresent()){
            Saving saving = savingRepository.findById(id).get();

            return this.modelMapper.map(saving, ResAccountDTO.class);

        } else if(creditCardOptional.isPresent()) {
            CreditCard creditCard = creditCardRepository.findById(id).get();

            return this.modelMapper.map(creditCard, ResAccountDTO.class);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The account doesn't exist");

        }
    }


    //GETTING ACCOUNT BY TYPE AND ID

    @Override
    public ResCheckingAccountDTO findCheckingById(Long id) {
        if(checkingRepository.findById(id).isPresent()){
            Checking checking = checkingRepository.findById(id).get();
            return this.modelMapper.map(checking, ResCheckingAccountDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Account doesn't exist");
            }
    }

    @Override
    public ResStudentCheckingAccountDTO findStudentCheckingById(Long id) {
        if(studentCheckingRepository.findById(id).isPresent()){
            StudentChecking studentChecking = studentCheckingRepository.findById(id).get();

            return this.modelMapper.map(studentChecking, ResStudentCheckingAccountDTO.class);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Account doesn't exist");
        }
    }

    public ResSavingAccountDTO findSavingById(Long id) {
        if(savingRepository.findById(id).isPresent()){
            Saving saving = savingRepository.findById(id).get();
            return this.modelMapper.map(saving, ResSavingAccountDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Account doesn't exist");
        }
    }


    public ResCreditCardAccountDTO findCreditCardById(Long id) {
        if(creditCardRepository.findById(id).isPresent()){
            CreditCard creditCard = creditCardRepository.findById(id).get();
            return this.modelMapper.map(creditCard, ResCreditCardAccountDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Account doesn't exist");
        }
    }




    // CREATING ACCOUNTS

    @Override
    public Account createCheckingAccount(CheckingDTO checkingDTO) {

        Holder primaryholderDB =  holderRepository.findById(checkingDTO.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary Holder not found"));

        LocalDate birthdate = primaryholderDB.getBirthDate();
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthdate, now);
        int age = period.getYears();

        if(age < 24){
            Holder secondaryholderDB;
            StudentChecking studentChecking;
            if(checkingDTO.getSecondOwnerId()!= null) {

                secondaryholderDB = holderRepository.findById(checkingDTO.getSecondOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Secondary Holder not found"));
                studentChecking = new StudentChecking(checkingDTO.getSecretKey(), primaryholderDB, secondaryholderDB);

                return studentCheckingRepository.save(studentChecking);
            }else{
            studentChecking = new StudentChecking(checkingDTO.getSecretKey(),primaryholderDB, null);
                return studentCheckingRepository.save(studentChecking);
            }

        } else {
            Holder secondaryholderDB;
            Checking checking;
            if(checkingDTO.getSecondOwnerId()!= null) {
                secondaryholderDB = holderRepository.findById(checkingDTO.getSecondOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Secondary Holder not found"));
                checking   = new Checking(checkingDTO.getSecretKey(), primaryholderDB, secondaryholderDB);
                return  checkingRepository.save(checking);
            }
            checking   = new Checking(checkingDTO.getSecretKey(), primaryholderDB, null);
            return  checkingRepository.save(checking);
        }

    }

    @Override
    public Account createSavingAccount(SavingDTO savingDTO) {

        Holder primaryholderDB =  holderRepository.findById(savingDTO.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary Holder not found"));

        Holder secondaryholderDB;
        Saving saving;

        if(savingDTO.getSecondOwnerId()!= null) {
            secondaryholderDB = holderRepository.findById(savingDTO.getSecondOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Secondary Holder not found"));

            saving   = new Saving(savingDTO.getSecretKey(), primaryholderDB, secondaryholderDB);
            return  savingRepository.save(saving);
        }
        saving   = new Saving(savingDTO.getSecretKey(), primaryholderDB, null);
        return  savingRepository.save(saving);

    }



    @Override
    public Account createCreditCardAccount(CreditCardDTO creditCardDTO) {
        Holder primaryholderDB =  holderRepository.findById(creditCardDTO.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary Holder not found"));

        Holder secondaryholderDB;
        CreditCard creditCard;
        if(creditCardDTO.getSecondOwnerId()!= null) {
            secondaryholderDB = holderRepository.findById(creditCardDTO.getSecondOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Secondary Holder not found"));
            creditCard   = new CreditCard(creditCardDTO.getSecretKey(), primaryholderDB, secondaryholderDB);
            return  creditCardRepository.save(creditCard);
        }
        creditCard   = new CreditCard(creditCardDTO.getSecretKey(), primaryholderDB, null);
        return  creditCardRepository.save(creditCard);
    }




    //UPDATE BALANCE

    @Override
    public void updateAccountBalance(Long id, AccountBalanceDTO accountBalanceDTO) {
        Optional<Checking> optionalChecking = checkingRepository.findById(id);
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(id);
        Optional<Saving> optionalSaving = savingRepository.findById(id);
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);

        if (optionalChecking.isPresent()){
            if(optionalChecking.get().getBalance() == accountBalanceDTO.getBalance()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account already has the same balance");
            }
            optionalChecking.get().setBalance(accountBalanceDTO.getBalance());
            checkingRepository.save(optionalChecking.get());

        } else if (optionalStudentChecking.isPresent()){
            if(optionalStudentChecking.get().getBalance() == accountBalanceDTO.getBalance()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account already has the same balance");
            }
            optionalStudentChecking.get().setBalance(accountBalanceDTO.getBalance());
            studentCheckingRepository.save(optionalStudentChecking.get());


        } else if (optionalSaving.isPresent()){
            if(optionalSaving.get().getBalance() == accountBalanceDTO.getBalance()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account already has the same balance");
            }
            optionalSaving.get().setBalance(accountBalanceDTO.getBalance());
            savingRepository.save(optionalSaving.get());


        } else if (optionalCreditCard.isPresent()){
            if(optionalCreditCard.get().getBalance() == accountBalanceDTO.getBalance()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account already has the same balance");
            }
            optionalCreditCard.get().setBalance(accountBalanceDTO.getBalance());
            creditCardRepository.save(optionalCreditCard.get());

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The account doesnt exist");
        }

    }


}
