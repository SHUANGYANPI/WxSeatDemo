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
        String More = "这个人很懒，什么都没留下";
        jdbcTemplate.update("insert into user(no,name,phone,qq,sex,jifen,more,password,count)values(?,?,?,?,?,?,?,?,?)",user.getNo(),user.getName(),user.getPhone(),user.getQQ(),user.getSex(),5,More,user.getPassword(),0);

        return null;
    }

    @Override
    public Map<String, Object> upDate(String shenFenZheng, String newPassword) {
        jdbcTemplate.update("update user set password=? where shenfenzheng=?",newPassword,shenFenZheng);
        return null;
    }

    @Override
    public Map<String, Object> FindUserByuno(String uno) {
        return jdbcTemplate.queryForMap("select * from user where no=?",uno);
    }

    @Override
    public Map<String, Object> CheckUserNo(String no) {
        try {
            Map map = jdbcTemplate.queryForMap("select * from had_choose where no=?",no);
            return map;
        }catch (Exception e){
            return null;
        }
    }
}
