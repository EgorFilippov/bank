package dao;

import entitys.Card;

import java.util.List;

public interface CardDao {
    void createCard(Long accountNumber);
    List<Card> getAllCardsByAccount(Long accountNumber);
}
