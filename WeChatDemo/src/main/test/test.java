import demo.Dao.UserDao;
import demo.Service.SeatService;
import demo.Service.imp.SeatServiceImp;
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
    @Test
    public void testsave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        SeatService seatService = ac.getBean("seatService", SeatServiceImp.class);
        boolean flag = seatService.DeleteSeatOfUser("123");
        System.out.println(flag);
    }
}
