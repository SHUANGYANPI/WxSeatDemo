package demo.Controller;

import demo.Service.SeatService;
import demo.Service.imp.UserServiceImp;
import demo.config.SendMail;
import demo.pojo.User;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller("studentController")
@RequestMapping("/studentController")
public class StudentController{

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    UserServiceImp userService = ac.getBean("userService", UserServiceImp.class);
    SeatService seatService = ac.getBean("seatService",SeatService.class);
    SendMail sendMail = ac.getBean("sendMail",SendMail.class);

    /**
     * 用户登录
     * @param userno
     * @return
     */
    @RequestMapping(value = "/Login",produces="text/html;charset=UTF-8")//登录
    public @ResponseBody String Login(@RequestBody String userno){
        JSONObject jsonObject = JSONObject.fromObject(userno);
        String uno = jsonObject.getString("uno");
        String password = jsonObject.getString("password");
        System.out.println(uno);
        if (jsonObject==null||uno.equals("")||password.equals("")){
            return "{\"flag\":\"false\"}";
        }
        Map<String,Object> map = userService.FindUserByNo(uno);
        if (map.get("password").equals(password)){
            return "{\"flag\":\"true\"}";
        }
        else {
            return "{\"flag\":\"false\"}";
        }
    }

    /**
     * 首页显示用户信息
     * @param userno
     * @return
     */
    @RequestMapping(value = "/findOneStudent",produces="text/html;charset=UTF-8")//produces="text/html;charset=UTF-8":(特别重要)加上才能将utf-8类型的数据传到前端
    public @ResponseBody String findOneStudent(@RequestBody String userno){

        String floor = "";
        String room = "";
        String sno = "";
        String flag = "";

        JSONObject jsonget = JSONObject.fromObject(userno);
        String no = jsonget.getString("uno");
        Map<String,Object> map = userService.FindUserByNo(no);//从user表里面查用户基本数据
        int jifen = (Integer) map.get("jifen");
        String sex = (String)map.get("sex");
        String more = (String)map.get("more");
        String name = (String)map.get("name");
        int count = (Integer) map.get("count");
        Map<String,Object> seat = userService.CheckUserNo(no);//从had_choose表里面查是否有no这个人，如果有，则表明这个学号已经占过位置
        System.out.println(seat);

        if (seat!=null){
            flag = "你已经选过座位";
            floor = (String) seat.get("floor")+"楼";//第floor层
            room = (String) seat.get("room");
            sno = (String) seat.get("sno")+"号座";
        }else{
            flag = "你还没有选座位";
            floor = "您";
            room = "不配";
            sno = "有座";
        }

        System.out.println(seat);

        return "{\"name\":\""+name+"\""+",\"sex\":\""+sex+"\""+",\"jifen\":\""+jifen+"\""+",\"more\":\""+more+"\""+",\"flag\":\""+flag+"\""+",\"count\":\""+count+"\""+",\"floorId\":\""+floor+"\""+",\"roomId\":\""+room+"\""+",\"noId\":\""+sno+"\"}";
    }

     /**
     * 修改密码
     * @param userdate
     * @return*/

    @RequestMapping(value = "/updateUser",produces="text/html;charset=UTF-8")
    public @ResponseBody String updateUser(@RequestBody String userdate){
        JSONObject jsonObject = JSONObject.fromObject(userdate);

        String uno = jsonObject.getString("uno");//获取学号，用学号找回密码
        String password = jsonObject.getString("password");
        Map<String,Object> map = userService.FindUserByuno(uno);
        if (map.get("uno").equals(uno)){
            userService.upDate(uno,password);
            return "{\"flag\":\"+true\"}";
        }
        else {
            return "{\"flag\":\"+false\"}";
        }
    }


    /**
     * 找回密码
     * @param userdata
     * @return*/
    @RequestMapping(value = "/findPassword",produces="text/html;charset=UTF-8")
    public @ResponseBody String findPassword(@RequestBody String userdata){

        JSONObject data = JSONObject.fromObject(userdata);
        String uno = data.getString("uno");
        String mail = data.getString("mail");

        Map<String,Object> user = userService.FindUserByNo(uno);
        String password = (String) user.get("password");

        boolean flag = sendMail.send(password,mail);
        if (flag){
            return null;
        }else {
            return null;
        }
    }


    /**
     * 学生注册
     * @param userdata
     * @return*/

    @RequestMapping(value = "/Register",produces="text/html;charset=UTF-8")
    public @ResponseBody String Register(@RequestBody String userdata){

        JSONObject jsonObject = JSONObject.fromObject(userdata);

        User user = new User();
        user.setNo(jsonObject.getString("no"));
        user.setName(jsonObject.getString("name"));
        user.setPhone(jsonObject.getString("phone"));
        user.setQQ(jsonObject.getString("qq"));
        user.setSex(jsonObject.getString("sex"));
        user.setPassword(jsonObject.getString("password"));

        userService.Register(user);
        return "{\"flag\":\"+true\"}";
    }




}
