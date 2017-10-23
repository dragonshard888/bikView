package com.centrabank.bik.server.repository;


import com.centrabank.bik.server.domain.TnpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TnpRepo extends JpaRepository<TnpEntity, String>{
    TnpEntity findOneByTnp(String tnp);
}
