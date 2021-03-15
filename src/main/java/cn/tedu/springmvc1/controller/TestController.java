package cn.tedu.springmvc1.controller;

import cn.tedu.springmvc1.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class TestController {
    @RequestMapping("/getuser")
    @ResponseBody
    public String getUser(Integer id, String name) {
        log.debug("收到信息：{},{}", id, name);
        return "处理了/getuser";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/getuser1")
    @ResponseBody
    public String getUser1(User user) {
        log.debug("表单信息：{}",user);
        return "利用Javabean接收参数";
    }
    @RequestMapping("/getuser2")
    @ResponseBody
    public String getUser2(User user) {
        log.debug("表单信息：{}",user);
        return "利用Javabean接收参数";
    }
    /**
     * 使用原生的servlet API检查用户IP
     */
    @GetMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session) {
        //.getRemoteAddr()在服务器端获取客户端的IP
        String ip = request.getRemoteAddr();
        log.debug("IP地址为：{}",ip);
        return "客户端:"+ip;

    }
    @GetMapping("/demo")
    public String demo(){
        return "hello";
    }
    /**
     * 在模板中显示信息
     */
    @GetMapping("/viewdemo")
    public ModelAndView veiwDemo(){
        ModelAndView mv = new ModelAndView();
        //在mv中添加视图模板名称为xxx
        mv.setViewName("message");
        //在mv中添加需要显示的数据
        mv.addObject("msg","hello");
        mv.addObject("user","Tom");
        return mv;
    }
    /**
     * 利用ModelMap传递数据
     * 将需要再视图上显示的数据 添加到map中
     * 方法返回值是视图名称
     * ModelMap是Map接口子类型
     * 可使用Map作为参数类型，结果完全一样
     * 考虑到ModelMap比Map有更明确的业务意义 建议使用前者
     */
    @GetMapping("/viewdemo2")
    public String viewDemo2(ModelMap map){
        map.put("msg","OK");
        map.put("user","wang");
        return "message";
    }
    /**
     * 测试SpringMVC提供的服务端重定向功能
     * 重定向：
     *      支持绝对地址重定向
     *      相对地址重定向 在当前网站内部重定向
     */
    @GetMapping("/doc")
    public String doc1(){
        log.debug("/doc");
        return "redirect:http://doc.canglaoshi.org";
    }

    @GetMapping("/hello")
    public String hello(){
        log.debug("/hello");
        return "redirect:/viewdemo2";
    }
    /**
     * 控制器标注了@RespsonseBody以后
     * 如果控制器返回Javabean 对象
     * SpringMVC 就会将Javabean对象转换为JSON返回
     */
    @GetMapping("/json")
    @ResponseBody
    public User json(){
        User user = new User().setId(1).setName(new String[]{"TOM","JERRY"});
        return user;
    }



}
