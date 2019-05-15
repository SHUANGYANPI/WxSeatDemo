package demo.Controller;

import demo.Service.imp.UserServiceImp;
import demo.pojo.User;
import net.sf.json.JSONArray;
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

    /**
     * 首页显示用户信息
     * @param userno
     * @return
     */
    @RequestMapping(value = "/findOneStudent",produces="text/html;charset=UTF-8")//produces="text/html;charset=UTF-8":(重要)加上才能将utf-8类型的数据传到前端
    public @ResponseBody String setUser(@RequestBody String userno){
        JSONObject jsonget = JSONObject.fromObject(userno);
        String no = jsonget.getString("uno");
        Map<String,Object> map = userService.FindUserByNo(no);
        JSONObject jsonput = new JSONObject();
        int jifen = (Integer) map.get("jifen");
        String sex = (String)map.get("sex");
        String more = (String)map.get("more");
        String name = (String)map.get("name");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(map);
        System.out.println(jsonArray);
//        return jsonArray;
        return "{\"name\":\""+name+"\""+",\"sex\":\""+sex+"\""+",\"jifen\":\""+jifen+"\""+",\"more\":\""+more+"\"}";
    }

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
        Map<String,Object> map = userService.FindUserByNo(uno);
        if (map.get("password").equals(password)){
            return "{\"flag\":\"true\"}";
        }
        else {
            return "{\"flag\":\"+false\"}";
        }
    }

     /**
     * 修改密码
     * @param userdate
     * @return*/

    @RequestMapping(value = "/updateUser",produces="text/html;charset=UTF-8")
    public @ResponseBody String updateUser(@RequestBody String userdate){
        JSONObject jsonObject = JSONObject.fromObject(userdate);
        System.out.println(jsonObject);
        String shenfenzheng = jsonObject.getString("shenfenzheng");
        String password = jsonObject.getString("password");
        Map<String,Object> map = userService.FindUserByShenFenZheng(shenfenzheng);
        if (map.get("shenfenzheng").equals(shenfenzheng)){
            userService.upDate(shenfenzheng,password);
            return "{\"flag\":\"+true\"}";
        }
        else {
            return "{\"flag\":\"+false\"}";
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
        user.setShenfenzheng(jsonObject.getString("shenfenzheng"));

        userService.Register(user);
        return "{\"flag\":\"+true\"}";
    }

}
