package com.oks.blog.service;

import com.oks.blog.model.User;
import com.oks.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional

    public void 회원가입(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = true) //select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료( 정합성 유지가능)
    public User 로그인(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
