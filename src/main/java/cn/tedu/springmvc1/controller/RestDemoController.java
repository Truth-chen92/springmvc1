package cn.tedu.springmvc1.controller;

import cn.tedu.springmvc1.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller+@ResponseBody
@RequestMapping("/api")
public class RestDemoController {
    @GetMapping("/test")
    public User user() {
        User user = new User().setId(10).setName(new String[]{"FAN","WANG"});
        return user;
    }
}
