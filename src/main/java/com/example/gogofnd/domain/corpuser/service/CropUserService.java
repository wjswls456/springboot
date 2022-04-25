package com.example.gogofnd.domain.corpuser.service;


import com.example.gogofnd.domain.corpuser.domain.CorpUser;
import com.example.gogofnd.domain.corpuser.dto.*;
import com.example.gogofnd.domain.corpuser.repository.CorpUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@ToString
public class CropUserService {

    private final CorpUserRepository corpUserRepository;



    public UserSaveResponseDto saveUser(UserSaveDto dto){

        CorpUser corpUser = CorpUser.saveUser(dto);
        corpUserRepository.save(corpUser);
        return new UserSaveResponseDto(corpUser);
    }


//    public List<UserSaveResponseDto>  selectUser(){
//
//        List<CorpUserDomain> corpUserDomainList = corpUserRepository.findAll();
//        //객체 --> dto 데이터 가공
//
//        return corpUserDomainList.stream().map(UserSaveResponseDto::new).collect(Collectors.toList());
//
//    }

    public PageUserDto userPage(int curPage,int limit,String sort,String orderby,String status,String search){

        Pageable sortedByName = PageRequest.of(curPage-1,limit, Sort.by(Sort.Direction.DESC,sort));

        if(orderby.equals("aes")){
             sortedByName = PageRequest.of(curPage-1,limit, Sort.by(Sort.Direction.ASC,sort));
        }

        Page<CorpUser> userPage = null;
        if(status.equals("1")){
            userPage = corpUserRepository.findByName(search,sortedByName);
        } else if(status.equals("2")){
            userPage = corpUserRepository.findByEngname(search,sortedByName);
        } else if(status.equals("3")){
            userPage = corpUserRepository.findByTeam(search,sortedByName);
        } else {
            userPage = corpUserRepository.findAll(sortedByName);
        }

        PageUserDto userPageDto  = new PageUserDto(curPage-1,userPage.getTotalPages(),userPage.getTotalElements(),userPage.stream().map(UserSaveResponseDto::new).collect(Collectors.toList()));

        return  userPageDto;
    }

    public UserSaveResponseDto updateUser(UserUpdateDto userUpdateDto){

        //1. req.dto에서 name 꺼낸다
        Long userSearchId = userUpdateDto.getId();
        // 커피

        //쿼리에 넣는다
        //2. req.dto에서 꺼낸 데이터를 쿼리문에 넣어 데이터 가져오기
        CorpUser getCorpUser = corpUserRepository.findById(userSearchId).get();
        //15 55 커피 010718331

        //3. 쿼리문에서 데이터를 수정
        getCorpUser.updateData(userUpdateDto);

        //4. 쿼리문에서 수정된 데이터를 Res Dto로 저장
        UserSaveResponseDto userSaveResponseDto = new UserSaveResponseDto(getCorpUser);

        return userSaveResponseDto;
    }

    public void deleteUser(UserDeleteDto userDeleteDto){

        //1. req.dto에서 id 꺼내온다
        Long userId = userDeleteDto.getId();
        //2. 삭제 쿼리문 실행
        corpUserRepository.deleteById(userId);
    }

}
