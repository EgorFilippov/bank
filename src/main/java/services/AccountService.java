package services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AccountService {
    String getBalance(long accountNumber);
    String changeBalance (long accountNumber, long value);

}