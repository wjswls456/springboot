package com.example.gogofnd.domain.corpuser.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserUpdateDto {

    private Long id;
    private String name;
    private String engname;
    private String team;

}
