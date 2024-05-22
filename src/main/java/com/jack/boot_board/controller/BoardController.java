package com.jack.boot_board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jack.boot_board.dto.BoardDto;
import com.jack.boot_board.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService bService;

     @GetMapping("/")
    public String getList(Model model) {
        System.out.println("list");
        List<BoardDto> bDtoList = bService.findAll();
        model.addAttribute("lists", bDtoList);
        return "list";
    }

    @GetMapping("/{id}")
    public String detailView(@PathVariable("id") Long id, Model model) {
        /**
         * 로직 
         * 1.조회수(hit)를 1 올리고 
         * 2.detial.html 을 출력
         */
        bService.updateHits(id);
        BoardDto bDto = bService.findById(id);
        model.addAttribute("board", bDto); 
        return "detail";
    }

    @GetMapping("/write")
    public String getWrite() {
        System.out.println("write");
        return "write";
    }
    
    @PostMapping("/write")
    public String setWrite(@ModelAttribute BoardDto bDto) { // setWrite에 글씨를 쓰면 dto에 들어간다.

        System.out.println("boardDto = " + bDto);
        bService.write(bDto);
        return "redirect:/board/";  //redirect를 하는 이유: 글쓰기 완료된 이후에 주소창도 넘어가기 위함.
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = bService.findById(id);
        model.addAttribute("board", boardDto);
        return "update";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDto bDto, Model model){

        List<BoardDto> bDtoList = bService.findAll();
        model.addAttribute("lists", bDtoList);

        return "history.go(-1)";
    }

}
