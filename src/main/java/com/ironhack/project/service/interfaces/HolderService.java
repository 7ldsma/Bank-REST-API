package com.ironhack.project.service.interfaces;

import com.ironhack.project.model.Account;
import com.ironhack.project.model.Money;

import java.util.List;

public interface HolderService {

    Money getBalance(Long id, int secretKey);



}
