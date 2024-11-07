package com.ironhack.project.controller.interfaces;

import com.ironhack.project.model.Account;
import com.ironhack.project.model.Money;

import java.util.List;

public interface HolderController {


    Money getBalance(Long id, int secretKey);

}
