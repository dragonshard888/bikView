package com.centrabank.bik.server.repository;

import com.centrabank.bik.server.domain.BnkseekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BnkseekRepo extends JpaRepository<BnkseekEntity, Long> {

    List<BnkseekEntity> findByNewnum(String bikField);

    List<BnkseekEntity> findByRgnName(String bikRegion);

    List<BnkseekEntity> findByPznVkey(String bikPznType);
}



