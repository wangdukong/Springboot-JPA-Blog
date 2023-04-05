package com.oks.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;


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
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
