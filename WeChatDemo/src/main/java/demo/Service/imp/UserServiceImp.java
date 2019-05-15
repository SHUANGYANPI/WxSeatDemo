package demo.Service.imp;

import demo.Dao.UserDao;
import demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userService")
public class UserServiceImp implements UserDao {

    @Autowired
    private UserDao userDao;

    public Map<String,Object> FindUserById(int id) {
        return userDao.FindUserById(id);
    }
    public Map<String,Object> Register(User user) {
        return userDao.Register(user);
    }

    public Map<String,Object> FindUserByNo(String no) {
        return userDao.FindUserByNo(no);
    }

    public Map<String,Object> FindUserByName(String name) {
        return userDao.FindUserByName(name);
    }

    public Map<String,Object> FindAllUser() {
        return userDao.FindAllUser();
    }

    @Override
    public Map<String, Object> upDate(String shenFenZheng, String newPassword) {
        return userDao.upDate(shenFenZheng,newPassword);
    }

    @Override
    public Map<String, Object> FindUserByShenFenZheng(String shenFenZheng) {
        return userDao.FindUserByShenFenZheng(shenFenZheng);
    }
}
