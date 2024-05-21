package com.jack.boot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.boot_board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{  //레포지토리에 entity이름(column 클래스) 과 key타입(id) 설정
    
}
