package demo.pojo;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
public class test {

    @RequestMapping("/testuser")
    public String testuser(){



        return "success";
    }
}
