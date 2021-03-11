package cn.tedu.springmvc1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {
@RequestMapping("/getuser")
    @ResponseBody
    public String getUser(Integer id,String name){
    log.debug("收到信息：{},{}",id,name);
    return "处理了/getuser";
}
}
