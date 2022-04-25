package com.example.gogofnd.domain.corpuser.dto;


import com.example.gogofnd.domain.corpuser.domain.CorpUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class UserSaveResponseDto {

    private Long id;
    private String name;
    private String team;
    private String engname;


    public UserSaveResponseDto(CorpUser corpUser){
        this.id = corpUser.getId();
        this.engname = corpUser.getEngname();
        this.name = corpUser.getName();
        this.team = corpUser.getTeam();
    }

}
