package com.oks.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // primary key

    @Column(nullable = false,length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content;

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne(fetch = FetchType.EAGER) //Many -> board, one -> user
    //EAGER 항상 불러옴

    @JoinColumn(name="userId") //그냥 name= user id 라 선언하면 user와 연관 관계가 없다. Manytoone으로 연관관계를 맺어줌
    private User user; // DB는 오브젝트 저장 X FK 사용 (foregin key : 외래키), 자바는 오브젝트 저장 가능

    //기본전략이 LAZY 데이터가 필요할 때 불러옴.
    @OneToMany(mappedBy = "board",fetch = FetchType.LAZY) //mappedBy 연관관계의 주인이 아님. FK 가 아니다. "board" 는 reply class의 Board 필드 이름을 적어준다.
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp creatDate;
}
