package com.example.zywa.controller;

import com.example.zywa.beans.CardStatus;
import com.example.zywa.service.CardStatusService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardStatusController {

    @Autowired
    private CardStatusService cardStatusService;
    
    
    @GetMapping("/health")
	public String sayHello() {
		return "Service is up...";
	}
    

    @GetMapping("/get_card_status/{cardIdOrPhone}")
    public CardStatus getCardStatus(@PathVariable String cardIdOrPhone) {
        return (CardStatus) cardStatusService.getCardStatusByCardId(cardIdOrPhone);
    }

    @GetMapping("/get_all_card_status")
    public List<CardStatus> getAllCardStatus() {
        return cardStatusService.getAllCardStatus();
    }

    @PostMapping("/save_card_status")
    public void saveCardStatus(@RequestBody CardStatus cardStatus) {
        cardStatusService.saveCardStatus(cardStatus);
    }

   

}