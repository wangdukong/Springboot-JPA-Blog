package com.oks.blog.controller.api;

import com.oks.blog.dto.ResponseDto;
import com.oks.blog.model.RoleType;
import com.oks.blog.model.User;
import com.oks.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;



    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController : save 호출됨");
        user.setRole(RoleType.USER);
        userService.회원가입(user);

       return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        System.out.println("UserApiController : login 호출됨");
        User principal=userService.로그인(user);

        if(principal!=null){
            session.setAttribute("principal",principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
