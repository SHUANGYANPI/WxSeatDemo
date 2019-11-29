package demo.Controller;

import demo.Service.SeatService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @ResponseBody
    public String FindRoomUsedSeat(@RequestBody String seatdata){
        JSONObject jsonGet = JSONObject.fromObject(seatdata);

        String send = "";
        System.out.println(jsonGet+"get");
        String floor = (String)jsonGet.get("floor");
        String room = (String)jsonGet.get("room");
        List<Map<String, Object>> lists = seatService.FindEveryEmptySeatOfFloorAndRoom(floor,room);
        //由于查询出来的数据没有用

/*        JSONObject jsonSend;
        List<JSONObject> list1 = new ArrayList<>();

        String send = "";
        for (Map<String, Object> map:lists){
             jsonSend = JSONObject.fromObject(map);
             list1.add(jsonSend);//将遍历出来的座位放入List中

        }*/

        JSONArray jsonSend1 = JSONArray.fromObject(lists);//将List类型转化为JSONArray对象，方便转化为JSON字符进行传送
        send = jsonSend1.toString();//转换为JSON字符串，进行数据传送

        return send;
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
