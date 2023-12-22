package com.example.zywa;

import com.example.zywa.beans.CardStatus;
import com.example.zywa.repo.CardStatusRepository;
import com.example.zywa.service.CardStatusService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ZywaApplicationTests {
	@Mock
    private CardStatusRepository repository;

    @InjectMocks
    private CardStatusService service;

    @Test
    void getCardStatus() {
        // Mock data
        CardStatus mockCardStatus = new CardStatus();
        mockCardStatus.setId("1");
        mockCardStatus.setCardId("12345");
        mockCardStatus.setUserContact("971534534534");
        mockCardStatus.setTimestamp("14-11-2023 12:00PM");

     // Mock repository response
        when(repository.findByCardId("12345")).thenReturn((List<CardStatus>) mockCardStatus);

       // Test the service method
     CardStatus result = (CardStatus) service.getCardStatusByCardId("12345");

        // Assert the result
//        assertEquals("14-11-2023 12:00PM", result.getTimestamp());
    }

}