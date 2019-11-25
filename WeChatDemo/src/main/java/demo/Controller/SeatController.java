package demo.Controller;

import demo.Service.SeatService;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller("seatController")
@RequestMapping("/seatController")
public class SeatController {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    SeatService seatService = ac.getBean("seatService",SeatService.class);

    /**
     * 选座位
     * @param roomdata
     * @return
     */
    @RequestMapping(value = "/SaveSeatOfUser",produces="text/html;charset=UTF-8")
    public @ResponseBody String SaveSeatOfUser(@RequestBody String roomdata){//选座位
        JSONObject jsonget = JSONObject.fromObject(roomdata);

        String floor = (String)jsonget.get("floor");
        String room = (String)jsonget.get("room");
        String sno = (String)jsonget.get("sno");
        String uno = (String)jsonget.get("uno");
        boolean flag = seatService.SaveSeatOfUser(uno,floor,room,sno);
        if (flag){
            return "{\"flag\":\"true\"}";
        }else {
            return "{\"flag\":\"false\"}";
        }

    }

    /**
     * 通过楼层和房间号获取此房间被使用的座位情况
     * @param seatdata
     * @return
     */
    @RequestMapping(value = "/FindRoomUsedSeat",produces="text/html;charset=UTF-8")
    public @ResponseBody String FindRoomUsedSeat(@RequestBody String seatdata){
        JSONObject jsonget = JSONObject.fromObject(seatdata);
        System.out.println(jsonget);
        String floor = (String)jsonget.get("floor");
        String room = (String)jsonget.get("room");
        Map<String,Object> map = seatService.FindEveryEmptySeatOfFloorAndRoom(floor,room);
        String id = (String) map.get("sno");
        int sid = Integer.valueOf(id).intValue();
        return "{\"no\":"+sid+"}";
    }

    /**
     * 删除此学生选择的座位状态
     * @param seatdata
     * @return
     */
    @RequestMapping(value = "/DeleteRoomUsedSeat",produces="text/html;charset=UTF-8")
    public @ResponseBody String DeleteRoomUsedSeat(@RequestBody String seatdata){
        JSONObject jsonget = JSONObject.fromObject(seatdata);
        String uno = (String)jsonget.get("uno");
        System.out.println(uno);
        boolean flag = seatService.DeleteSeatOfUser(uno);
        if (flag){
            return "{\"flag\":\"true\"}";
        }else {
            return "{\"flag\":\"false\"}";
        }
    }

/*    @RequestMapping(value = "/findThisSeatByUid",produces="text/html;charset=UTF-8")
    public @ResponseBody String findThisSeatByUid(@RequestBody String uno){
        JSONObject jsonget = JSONObject.fromObject(uno);
        String no = (String)jsonget.get("uno");
        Map<String,Object> seat = seatService.FindThisSeatByUid(no);
        System.out.println(seat);
        String floor = (String) seat.get("floor");//第floor层
        String room = (String) seat.get("room");
        String sno = (String) seat.get("sno");
        return "{\"floor\":\""+floor+"\""+",\"room\":\""+room+"\""+",\"sno\":\""+sno+"\"}";
    }*/
}
