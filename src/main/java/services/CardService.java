package services;

public interface CardService {

    void createCard(Long accountNumber);
    String getAllCardsByAccount (Long accountNumber);

}
