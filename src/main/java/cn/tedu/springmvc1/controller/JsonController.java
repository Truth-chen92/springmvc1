package cn.tedu.springmvc1.controller;

import cn.tedu.springmvc1.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/api")
public class JsonController {
    /**
     * 在控制器类上标注@ResponseBody 相当于全部控制器方法都支持JSON
     * 由于在类上标注了@RequestMapping("/api")
     * 则请求路径增加一层路径
     * http://localhost:8080/api/user
     * @return
     */
    @GetMapping("/user")
    public User user() {
        User user = new User().setId(12).setName(new String[]{"熊大","熊二"});
        return user;
    }
}
