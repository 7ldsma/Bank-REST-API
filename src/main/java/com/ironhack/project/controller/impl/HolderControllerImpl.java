package com.ironhack.project.controller.impl;

import com.ironhack.project.controller.interfaces.HolderController;
import com.ironhack.project.model.Account;
import com.ironhack.project.model.Money;
import com.ironhack.project.repository.*;
import com.ironhack.project.service.interfaces.HolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/holder")
public class HolderControllerImpl implements HolderController {



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
    private HolderService holderService;




    @GetMapping("/accountId/{id}/{secretKey}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable Long id, @RequestParam @Valid int secretKey) {

        return holderService.getBalance(id, secretKey);
    }






}
