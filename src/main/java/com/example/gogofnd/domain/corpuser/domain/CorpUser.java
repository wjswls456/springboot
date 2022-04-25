package com.example.gogofnd.domain.corpuser.domain;


import com.example.gogofnd.domain.corpuser.dto.UserSaveDto;
import com.example.gogofnd.domain.corpuser.dto.UserUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class CorpUser {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String engname;

    private String team;



    public static CorpUser saveUser(UserSaveDto dto){

        return CorpUser.builder()
                .engname(dto.getEngname())
                .name(dto.getName())
                .team(dto.getTeam())
                .build();

    }

    public void updateData(UserUpdateDto userUpdateDto){
        this.name = userUpdateDto.getName();
        this.engname = userUpdateDto.getEngname();
        this.team = userUpdateDto.getTeam();
    }

}
