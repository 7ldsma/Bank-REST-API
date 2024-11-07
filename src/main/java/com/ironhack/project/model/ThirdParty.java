package com.ironhack.project.model;

import jakarta.persistence.*;


@Entity
public class ThirdParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int hashKey;

    private Money amount;
    private Long senderAcID;
    private Long receiverAcID;





    //CONSTRUCTORS


    public ThirdParty() {

    }

    public ThirdParty(String name, int hashKey, Money amount, Long senderAcID, Long receiverAcID) {
        this.name = name;
        this.hashKey = hashKey;
        this.amount = amount;
        this.senderAcID = senderAcID;
        this.receiverAcID = receiverAcID;
    }




//GETTERS & SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHashKey() {
        return hashKey;
    }

    public void setHashKey(int hashKey) {
        this.hashKey = hashKey;
    }
}
