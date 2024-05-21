package com.jack.boot_board.entity;

import com.jack.boot_board.dto.BoardDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="bboard")
public class BoardEntity extends TimesEntity {    //spring-boot에서는 entity가 mysql의 db와 같다!!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=20, nullable = false)
    private String bwriter;
    
    @Column(length=20, nullable = false)
    private String pass;

    @Column(length=255, nullable = false)
    private String title;

    @Column(length=1000, nullable = false)
    private String contents;

    @Column
    private int hits;

    public static BoardEntity toBoardEntity(BoardDto bDto){
        BoardEntity bEntity = new BoardEntity();

        bEntity.setBwriter(bDto.getBwriter());
        bEntity.setPass(bDto.getPass());
        bEntity.setTitle(bDto.getTitle());
        bEntity.setContents(bDto.getContents());
        bEntity.setHits(0);

        //날짜는 db에서 저절로 생성되기 때문에 안해줘도 된다.

        return bEntity;
    }
}
