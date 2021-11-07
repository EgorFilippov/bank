package dao;

import entitys.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class AccountDaoImpl implements AccountDao{

    @Override
    public Account getBalance(long accountNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String queryString = "from Account where accountNumber = :accountNumber1";
        Account account = session.createQuery(queryString, Account.class).setParameter("accountNumber1",accountNumber).getSingleResult();
        tx1.commit();
        session.close();
        return account;
    }

    @Override
    public Account changeBalance(long accountNumber, long value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String queryString = "from Account where accountNumber = :accountNumber1";
        Account account = session.createQuery(queryString, Account.class).setParameter("accountNumber1",accountNumber).getSingleResult();
        long currentBalance = account.getBalance();
        account.setBalance(currentBalance + value);
        tx1.commit();
        session.close();
        return account;
    }
}
