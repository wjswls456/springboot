package com.example.gogofnd.domain.corpuser.repository;

import com.example.gogofnd.domain.corpuser.domain.CorpUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpUserRepository extends JpaRepository<CorpUser,Long> {

     Page<CorpUser> findByName(String name, Pageable page);
     Page<CorpUser> findByEngname(String engname,Pageable page);
     Page<CorpUser> findByTeam(String team,Pageable page);
}
