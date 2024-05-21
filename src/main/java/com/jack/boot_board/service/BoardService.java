package com.jack.boot_board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jack.boot_board.dto.BoardDto;
import com.jack.boot_board.entity.BoardEntity;
import com.jack.boot_board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class BoardService {
    private final BoardRepository boardRepository; //다시 수정할 수 없도록 final로 가지고 온다.
    
    public void write(BoardDto bDto){
        BoardEntity bEntity = BoardEntity.toBoardEntity(bDto);  //dto를 받아서 entity안에 넣어준다.
        boardRepository.save(bEntity);  //레포지토리에서 save 되면서 쿼리문이 만들어진다. save는 레포지토리 내장메소드
    }
    
    public List<BoardDto> findAll(){
        //column에 있는 모든 내용을 가져옴
        List<BoardEntity> bEntities = boardRepository.findAll();

        //BoardDto 타입의 ArrayList를 만듦
        List<BoardDto> bDtos = new ArrayList<>();

        //위에서 만든 ArrayList 박스에 column에서 가져온 내용을 채움
        for(BoardEntity bEntity : bEntities){
            bDtos.add(BoardDto.toBoardDto(bEntity));
        }
        return bDtos;
    }
}
