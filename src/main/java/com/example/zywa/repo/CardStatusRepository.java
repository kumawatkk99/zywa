package com.example.zywa.repo;

import com.example.zywa.beans.CardStatus;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

//public interface CardStatusRepository extends MongoRepository<CardStatus, String> {
//
//    CardStatus findByCardIdOrUserContact(String cardId, String userContact);

//}
public interface CardStatusRepository extends MongoRepository<CardStatus, String> {

    List<CardStatus> findByCardId(String cardId);

    List<CardStatus> findByUserContact(String userContact);
}