package com.centrabank.bik.server.repository;


import com.centrabank.bik.server.domain.PznEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface PznRepo extends JpaRepository<PznEntity, String>{
    PznEntity findOneByPzn(String pzn);
}

