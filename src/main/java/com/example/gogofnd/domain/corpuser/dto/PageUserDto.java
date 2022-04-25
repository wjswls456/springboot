package com.example.gogofnd.domain.corpuser.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
public class PageUserDto {

    private int curPage;
    private int totalPage;
    private Long totalCount;
    private List<UserSaveResponseDto> userList;

    public PageUserDto(int curpage , int totalPage, Long totalCount, List<UserSaveResponseDto> userSaveResponseDto){
        this.curPage = curpage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.userList = userSaveResponseDto;
    }
}
