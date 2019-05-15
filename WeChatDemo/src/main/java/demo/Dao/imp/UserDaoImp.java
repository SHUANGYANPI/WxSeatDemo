package demo.Dao.imp;

import demo.Dao.UserDao;
import demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("userDao")
public class UserDaoImp implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> FindUserById(int id) {
        return jdbcTemplate.queryForMap("select * from user where uid=?",id);

    }

    public Map<String,Object> FindUserByNo(String no) {
        return jdbcTemplate.queryForMap("select * from user where no=?",no);
    }

    public Map<String,Object> FindUserByName(String name) {
        return jdbcTemplate.queryForMap("select * from user where name=?",name);

    }

    public Map<String,Object>  FindAllUser() {
        return jdbcTemplate.queryForMap("select * from user");
    }

    public Map<String,Object> Register(User user) {
        jdbcTemplate.update("insert into user(no,name,phone,qq,is_had)values(?,?,?,?,?)",user.getNo(),user.getName(),user.getPhone(),user.getQQ(),0);

        return null;
    }

    @Override
    public Map<String, Object> upDate(String shenFenZheng, String newPassword) {
        jdbcTemplate.update("update user set password=? where shenfenzheng=?",newPassword,shenFenZheng);
        return null;
    }

    @Override
    public Map<String, Object> FindUserByShenFenZheng(String shenFenZheng) {
        return jdbcTemplate.queryForMap("select * from user where shenfenzheng=?",shenFenZheng);
    }
}
