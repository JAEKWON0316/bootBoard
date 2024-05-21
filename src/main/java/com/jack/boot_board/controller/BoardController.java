package com.jack.boot_board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

     @GetMapping("/list")
    public String getList(Model model) {
        System.out.println("list");
        List<BoardDto> bDtoList = bService.findAll();
        model.addAttribute("lists", bDtoList);
        return "list";
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
        return "redirect:list";
    }
    
}
