package dao;

import entitys.Account;

public interface AccountDao {
    Account getBalance (long accountNumber);
    Account changeBalance (long accountNumber, long value);
}
