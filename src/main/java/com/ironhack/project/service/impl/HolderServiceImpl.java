package com.ironhack.project.service.impl;

import com.ironhack.project.model.*;
import com.ironhack.project.repository.*;
import com.ironhack.project.service.interfaces.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HolderServiceImpl implements HolderService {


    @Autowired
    private HolderRepository holderRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private SavingRepository savingRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;



    @Override
    public Money getBalance(Long id, int secretKey) {

        Optional<Checking> checkingOptional = checkingRepository.findById(id);
        Optional<StudentChecking> studentCheckingOptional = studentCheckingRepository.findById(id);
        Optional<Saving> savingOptional = savingRepository.findById(id);
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(id);

        if (checkingOptional.isPresent()){
            if(checkingOptional.get().getSecretKey() == secretKey){
                return checkingOptional.get().getBalance();
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The provided password is not correct.");
            }

        } else if (studentCheckingOptional.isPresent()){
            if(studentCheckingOptional.get().getSecretKey() == secretKey) {
                return studentCheckingOptional.get().getBalance();
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The provided password is not correct.");
            }

        } else if (savingOptional.isPresent()){
            if(savingOptional.get().getSecretKey() == secretKey) {
                return savingOptional.get().getBalance();
            }else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The provided password is not correct.");
            }

        } else if(creditCardOptional.isPresent()) {
            if(savingOptional.get().getSecretKey() == secretKey) {
                return creditCardOptional.get().getBalance();
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The provided password is not correct.");
            }

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The account doesn't exist");

        }

    }





}
