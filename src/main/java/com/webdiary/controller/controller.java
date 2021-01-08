package com.webdiary.controller;

import com.webdiary.entity.Customer;
import com.webdiary.entity.LoginRequestBean;
import com.webdiary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 56835 on 2020-05-20.
 */
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
//responseBody表示服务器返回的时候以一种什么样的方式进行返回， 将内容或对象作为 HTTP 响应正文返回，值有很多，一般设定为json
//使用的效果是将方法返回的对象直接在浏览器上展示成json格式，而如果单单使用@Controller会报错，需要ResponseBody配合使用。
//@RestController
@Controller
@RequestMapping("/get")
public class controller {
    @Autowired
    CustomerService customerService;

    //http://localhost:8080/get/CustomerByName?customerName=allen
    @ResponseBody
    @GetMapping(value = "/CustomerByName")
    //@RequestMapping(value = "/CustomerByName", method = RequestMethod.GET)//post不起作用
    public Customer showCustomerByName(@RequestParam(value = "customerName")String customerName){
        return customerService.getCustomerByName(customerName);
    }

    @ResponseBody
    @RequestMapping("/login")
    //RequestBody 作用在形参上，用于将前台发送过来固定格式的数据（json/xml）封装为对应的Bean对象，封装时使用到的一个对象是系统默认配置的
    // HttpMessageConverter进行解析，然后封装到形参上。
    // HttpServletRequest对象代表客户端的一次请求，当客户端通过HTTP协议访问服务器时，HTTP请求头中的所有信息都封装在这个对象中，通过这个对象提供的方法，
    // 可以获得客户端请求的所有信息。
    //request.getParameter()是获取URL里面的parameter（比如customerName）return String。 Map
    //request.getAttribute()是获取attribute值，该值是在服务器端赋值的 return 任意对象。 Map
    //session.invalidate()使之无效和与该session绑定的对象解绑
    //无效：session还在，但是parameter和attribute获取会抛出异常
    //解绑：如果调用request.getSession(false)方法，返回值会是null——即此时request没有绑定任何Session
    //后执行request.getSession()或者request.getSession(true),那么此时会创建一个新的Session给该Request对象绑定；需要特殊说明的是，
    // getSession()无参和参数为true的效果是一样的，并且此时如果你再次执行request.getSession(false)方法，返回的就不是null了，而是上面新创建的Session对象
    public String login(@RequestBody LoginRequestBean loginRequestBean, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        return null;
    }


}
