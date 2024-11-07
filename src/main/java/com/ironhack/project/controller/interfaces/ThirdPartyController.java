package com.ironhack.project.controller.interfaces;

import com.ironhack.project.model.Money;
import com.ironhack.project.model.ThirdParty;

public interface ThirdPartyController {

    ThirdParty transfer(Long senderId, Long receiverId, Money amount);

}
