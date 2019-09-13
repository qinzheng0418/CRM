package service;

import dao.UserDao;
import domain.User;
import utils.UUIDUtils;

public class UserService {
    public  boolean registerUser(User user) throws Exception {
        UserDao userDao = new UserDao();
        user.setUid(UUIDUtils.getUid());
        boolean b = userDao.findUser(user);
        if(b){
            System.out.println("用户名已经存在");
        }else {
            userDao.insretUser(user);
        }

        return b;
    }
}
