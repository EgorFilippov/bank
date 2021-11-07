package services;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    public void createUser(String userName) {
        System.out.println("UserService");
        UserDao userDao = new UserDaoImpl();
        userDao.createUser(userName);
    }
}