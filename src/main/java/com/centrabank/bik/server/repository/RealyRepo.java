package com.centrabank.bik.server.repository;


import com.centrabank.bik.server.domain.RealyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RealyRepo extends JpaRepository<RealyEntity, String>{
    RealyEntity findOneByRealy(String real);
}

