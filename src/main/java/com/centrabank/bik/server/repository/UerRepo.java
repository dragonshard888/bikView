package com.centrabank.bik.server.repository;


import com.centrabank.bik.server.domain.UerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UerRepo extends JpaRepository<UerEntity, String>{
    UerEntity findOneByUer(String uer);
}
