package com.jack.boot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jack.boot_board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{  //레포지토리에 entity이름(column 클래스) 과 key타입(id) 설정

    /* 조회수 증가 */
    @Modifying
    @Query(value = "update BoardEntity b set b.hits=b.hits+1 where b.id=:id")// update bboard set hits=hits+1 where id = ? 와 똑같다.  
    void updateHits(@Param("id") Long id);

    /* 업데이트 */
    @Modifying
    @Query(value = "update BoardEntity b set b.updated_time=:bbsUpdatedTime , b.title = ':title' , b.contents = ':contents' where b.id=:id")
    void update(@Param("id") Long id);
}   
