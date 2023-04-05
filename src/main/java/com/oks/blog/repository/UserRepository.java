package com.oks.blog.repository;

import com.oks.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username,String password);//jpa 네이밍 쿼리 전략
    //SELECT * FROM user WHERE username =(첫번째 파라미터) and password=(두번째 파라미터)
}
