package com.centrabank.bik.server.repository;


import com.centrabank.bik.server.domain.RegEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegRepo extends JpaRepository<RegEntity, String>{
    RegEntity findOneByRgn(String rgn);
}
