package com.jack.boot_board.dto;

import java.time.LocalDateTime;

import com.jack.boot_board.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@NoArgsConstructor  //기본생성자 생성
@AllArgsConstructor //필드 모든생성자 생성
public class BoardDto {
    private long id;
    private String bwriter;
    private String pass;
    private String title;
    private String contents;
    private int hits;
    private LocalDateTime bbsCreatedTime; //insert
    private LocalDateTime bbsUpdatedTime; //update

    public static BoardDto toBoardDto(BoardEntity bEntity){
        BoardDto bDto = new BoardDto();

        bDto.setId(bEntity.getId());
        bDto.setBwriter(bEntity.getBwriter());
        bDto.setPass(bEntity.getPass());
        bDto.setTitle(bEntity.getTitle());
        bDto.setContents(bEntity.getContents());
        bDto.setHits(bEntity.getHits());
        bDto.setBbsCreatedTime(bEntity.getCreatedTime());
        bDto.setBbsUpdatedTime(bEntity.getUpdatedTime());

        return bDto;
    }
    public BoardDto(Long id, String bwriter, int hits, String title, LocalDateTime bbsCreatedTime){
        this.id = id;
        this.bwriter = bwriter;
        this.hits = hits;
        this.title = title;
        this.bbsCreatedTime = bbsCreatedTime;
    }
}
