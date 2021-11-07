package dao;

import entitys.Account;
import entitys.Card;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CardDaoImpl implements CardDao{
    @Override
    public void createCard(Long accountNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String queryString = "from Account where accountNumber = :accountNumber1";
        Account account = session.createQuery(queryString, Account.class).setParameter("accountNumber1",accountNumber).getSingleResult();

        Card card = new Card(account);
        card.setAccount(account);
        account.setCard(card);

        session.save(card);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Card> getAllCardsByAccount(Long accountNumber) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String queryString = "from Card where account.accountNumber = :accountNumber1";
        List<Card> result = session.createQuery(queryString, Card.class).setParameter("accountNumber1",accountNumber).getResultList();
        tx1.commit();
        session.close();
        return result;
    }

}
