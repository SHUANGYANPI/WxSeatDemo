import demo.Dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class test {
    @Test
    public void testdao(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = ac.getBean("userDao",UserDao.class);
        Map<String,Object> map = userDao.FindUserByNo("20172411");
        System.out.println(map);
    }
}
