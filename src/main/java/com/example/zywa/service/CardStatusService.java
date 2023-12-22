package com.example.zywa.service;

import com.example.zywa.beans.CardStatus;
import com.example.zywa.repo.CardStatusRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardStatusService {
	
	@Autowired
  private CardStatusRepository repository;

  public List<CardStatus> getAllCardStatus() {
      return repository.findAll();
  }

  public Optional<CardStatus> getCardStatusById(String id) {
      return repository.findById(id);
  }

  public List<CardStatus> getCardStatusByCardId(String cardId) {
      return repository.findByCardId(cardId);
  }

  public List<CardStatus> getCardStatusByUserContact(String userContact) {
      return repository.findByUserContact(userContact);
  }

  public void saveCardStatus(CardStatus cardStatus) {
      repository.save(cardStatus);
  }

  public void deleteCardStatusById(String id) {
      repository.deleteById(id);
  }

  public void importCSV(String csvFileName) {
    try (CSVReader reader = new CSVReader(new FileReader("data/" + csvFileName))) {
        List<String[]> lines = reader.readAll();
        for (String[] line : lines) {
            CardStatus cardStatus = new CardStatus();
            cardStatus.setCardId(line[1]);
            cardStatus.setUserContact(line[2]);
            cardStatus.setTimestamp(line[3]);
            cardStatus.setComment(line.length > 4 ? line[4] : null);

            repository.save(cardStatus);
        }
    } catch (IOException | CsvException e) {
        e.printStackTrace();
    }
}

}
