package com.ironhack.project.controller.impl;

import com.ironhack.project.repository.CheckingRepository;
import com.ironhack.project.repository.CreditCardRepository;
import com.ironhack.project.repository.SavingRepository;
import com.ironhack.project.repository.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class ThirdPartyControllerImpl {

    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private SavingRepository savingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;





}
