package com.oks.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder // 빌더 패턴

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity //User 클래스를 읽어서 자동으로 mysql에 테이블 생성.
@DynamicInsert  // null 값은 값을 넣지 않음
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private int id;

    @Column(nullable = false,length = 30)
    private String username;
    @Column(nullable = false,length = 100)
    private String password;
    @Column(nullable = false,length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role; //String을 사용하면 실수를 할 수 있기 때문에, Enum을 사용하는 것이 좋다. //ADMIN,USER
    @CreationTimestamp
    private Timestamp createDate;
}
