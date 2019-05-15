package demo.Controller;

import demo.Service.SeatService;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("seatController")
public class SeatController {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    SeatService seatService = ac.getBean("seatService",SeatService.class);

    @RequestMapping(value = "/UpdateSeatStatus",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String Choose(@RequestBody String roomdata){
        JSONObject jsonObject = JSONObject.fromObject(roomdata);

        return null;

    }
}
