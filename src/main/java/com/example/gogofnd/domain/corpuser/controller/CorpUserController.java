package com.example.gogofnd.domain.corpuser.controller;


import com.example.gogofnd.domain.corpuser.dto.*;
import com.example.gogofnd.domain.corpuser.service.CropUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CorpUserController {

    private final CropUserService cropUserService;


//    @GetMapping("/corpuser")
//    public List<UserSaveResponseDto> findAllUser(){
//        return cropUserService.selectUser();
//    }

    //회사사람 데이터 추가
    @PostMapping("/corpuser")
    public UserSaveResponseDto saveUser(@RequestBody UserSaveDto dto){
        return cropUserService.saveUser(dto);
    }


    //회사사람 데이터 조회
    @GetMapping("/corpuser")
    public PageUserDto corpUser(@RequestParam(name = "curpage",defaultValue = "1") int curPage,
                            @RequestParam(name = "limit",defaultValue = "10") int limit,
                            @RequestParam(name = "sort",defaultValue = "id") String sort,
                            @RequestParam(name = "orderby",defaultValue = "des") String orderby,
                            @RequestParam(name = "status",defaultValue = "") String status,
                            @RequestParam(name = "search",defaultValue = "") String search

    ){
        if(curPage <=0) curPage = 1;
        return cropUserService.userPage(curPage,limit,sort,orderby,status,search);
    }

    //회사사람 데이터 업데이트
    @PutMapping("/corpuser")
    public UserSaveResponseDto corpUserUpdate(@RequestBody UserUpdateDto dto){
        return cropUserService.updateUser(dto);
    }

    //회사람 데이터 삭제
    @DeleteMapping("/corpuser")
    public void corpUserDelete(@RequestBody UserDeleteDto dto){
         cropUserService.deleteUser(dto);
    }


}
