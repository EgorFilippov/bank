package dao;

import entitys.Account;
import entitys.Card;
import entitys.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class UserDaoImpl implements UserDao{
    @Override
    public void createUser(String userName) {
        System.out.println("UserDaoImpl, name: " + userName);
        User user = new User(userName);
        Account account = new Account();
//        Card card = new Card(account);
        account.setUser(user);
        user.setAccount(account);
//        card.setAccount(account);
//        account.setCard(card);

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
//        session.update(user);
//        session.merge(user);
        session.save(user);
        tx1.commit();
        session.close();
    }

}
