package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountDao;
import dao.AccountDaoImpl;
import entitys.Account;

public class AccountServiceImpl implements AccountService{
    public String getBalance (long accountNumber) {
        String s = null;
        try {
            AccountDao accountDao = new AccountDaoImpl();
            Account account = accountDao.getBalance(accountNumber);
            ObjectMapper objectMapper = new ObjectMapper();
            s = objectMapper.writeValueAsString(account);
        }
        catch (JsonProcessingException e) {
            /**/
        }
        return s;
    }

    public String changeBalance (long accountNumber, long value) {
        String s = null;
        try {
            AccountDao accountDao = new AccountDaoImpl();
            Account account = accountDao.changeBalance(accountNumber, value);
            ObjectMapper objectMapper = new ObjectMapper();
            s = objectMapper.writeValueAsString(account);
        }
        catch (JsonProcessingException e) {
            /**/
        }
        return s;
    }
}
