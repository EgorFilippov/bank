package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CardDao;
import dao.CardDaoImpl;
import entitys.Card;

import java.util.List;

public class CardServiceImpl implements CardService{
    public void createCard(Long accountNumber) {
        System.out.println("CardService");
        CardDao cardDao = new CardDaoImpl();
        cardDao.createCard(accountNumber);
    }

    public String getAllCardsByAccount (Long accountNumber) {
        CardDao cardDao = new CardDaoImpl();
        List <Card> cardList = cardDao.getAllCardsByAccount(accountNumber);
        StringBuilder sb = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (Card c : cardList) {
                sb.append(objectMapper.writeValueAsString(c));
            }
        } catch (JsonProcessingException e) {
            /**/
        }
        return sb.toString();
    }

}
