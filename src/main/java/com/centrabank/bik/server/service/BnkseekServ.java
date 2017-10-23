package com.centrabank.bik.server.service;


import com.centrabank.bik.server.domain.*;
import com.centrabank.bik.server.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BnkseekServ {
    Logger log = LoggerFactory.getLogger(BnkseekServ.class);

    @Autowired
    private BnkseekRepo bnkseekRepo;
    @Autowired
    private RealyRepo realyRepo;
    @Autowired
    private PznRepo pznRepo;
    @Autowired
    private RegRepo regRepo;
    @Autowired
    private UerRepo uerRepo;
    @Autowired
    private TnpRepo tnpRepo;

    @Autowired
    private ParserForDBF parser;

    //пропарсим имеющиеся файлы для бд
    @PostConstruct
    private void  fullingDataBase(){
        log.info("Начали прасинг REALY");
        List<RealyEntity> realyList = new ArrayList<>();
        Map<Integer, Map<String, Object>> mapDbfRealy = parser.parseDBF("src/main/resources/dbf/REAL.DBF");
        for (Map.Entry<Integer, Map<String, Object>> mapEntry : mapDbfRealy.entrySet()) {
            RealyEntity realy = new RealyEntity();
            realy.setVkey(mapEntry.getValue().get("VKEY").toString());
            realy.setRealy(mapEntry.getValue().get("REAL").toString());
            realy.setNameOgr(mapEntry.getValue().get("NAME_OGR").toString().trim());
            realyList.add(realy);
        }
        realyRepo.save(realyList);

        log.info("Начали прасинг PZN");
        List<PznEntity> pznList = new ArrayList<>();
        Map<Integer, Map<String, Object>> mapDbfPzn = parser.parseDBF("src/main/resources/dbf/PZN.DBF");
        for (Map.Entry<Integer, Map<String, Object>> mapEntry : mapDbfPzn.entrySet()) {
            PznEntity pzn = new PznEntity();
            pzn.setVkey(mapEntry.getValue().get("VKEY").toString());
            pzn.setPzn(mapEntry.getValue().get("PZN").toString());
            pzn.setImy(mapEntry.getValue().get("IMY").toString().trim());
            pzn.setName(mapEntry.getValue().get("NAME").toString().trim());
            pznList.add(pzn);
        }
        pznRepo.save(pznList);


        log.info("Начали прасинг REG");
        List<RegEntity> regList = new ArrayList<>();
        Map<Integer, Map<String, Object>> mapDbfReg = parser.parseDBF("src/main/resources/dbf/REG.DBF");
        for (Map.Entry<Integer, Map<String, Object>> mapEntry : mapDbfReg.entrySet()) {
            RegEntity reg = new RegEntity();
            reg.setVkey(mapEntry.getValue().get("VKEY").toString());
            reg.setRgn(mapEntry.getValue().get("RGN").toString());
            reg.setName(mapEntry.getValue().get("NAME").toString().trim());
            regList.add(reg);
        }
        regRepo.save(regList);

        log.info("Начали прасинг TNP");
        List<TnpEntity> tnpList = new ArrayList<>();
        Map<Integer, Map<String, Object>> mapDbfTnp = parser.parseDBF("src/main/resources/dbf/TNP.DBF");
        for (Map.Entry<Integer, Map<String, Object>> mapEntry : mapDbfTnp.entrySet()) {
            TnpEntity tnp = new TnpEntity();
            tnp.setVkey(mapEntry.getValue().get("VKEY").toString());
            tnp.setTnp(mapEntry.getValue().get("TNP").toString());
            tnp.setFullname(mapEntry.getValue().get("FULLNAME").toString().trim());
            tnp.setShortname(mapEntry.getValue().get("SHORTNAME").toString().trim());
            tnpList.add(tnp);
        }
        tnpRepo.save(tnpList);

        log.info("Начали прасинг UER");
        List<UerEntity> uerList = new ArrayList<>();
        Map<Integer, Map<String, Object>> mapDbfUer = parser.parseDBF("src/main/resources/dbf/UER.DBF");
        for (Map.Entry<Integer, Map<String, Object>> mapEntry : mapDbfUer.entrySet()) {
            UerEntity uer = new UerEntity();
            uer.setVkey(mapEntry.getValue().get("VKEY").toString());
            uer.setUer(mapEntry.getValue().get("UER").toString().trim());
            uer.setUername(mapEntry.getValue().get("UERNAME").toString().trim());
            uerList.add(uer);
        }
        uerRepo.save(uerList);

        log.info("Начали прасинг Bnkseek");
        List<BnkseekEntity> bnkseekList = new ArrayList<>();
        Map<Integer, Map<String, Object>> mapDbf = parser.parseDBF("src/main/resources/dbf/BNKSEEK.DBF");
        for (Map.Entry<Integer, Map<String, Object>> mapEntry : mapDbf.entrySet()) {
            BnkseekEntity bnkseek = new BnkseekEntity();
            bnkseek.setRealy(realyRepo.findOneByRealy(mapEntry.getValue().get("REAL").toString()));
            bnkseek.setPzn(pznRepo.findOneByPzn(mapEntry.getValue().get("PZN").toString()));
            bnkseek.setUer(uerRepo.findOneByUer(mapEntry.getValue().get("UER").toString()));
            bnkseek.setRgn(regRepo.findOneByRgn(mapEntry.getValue().get("RGN").toString()));
            bnkseek.setInd(mapEntry.getValue().get("IND").toString().trim());
            bnkseek.setTnp(tnpRepo.findOneByTnp(mapEntry.getValue().get("TNP").toString()));
            bnkseek.setNnp(mapEntry.getValue().get("NNP").toString().trim());
            bnkseek.setAddr(mapEntry.getValue().get("ADR").toString().trim());
            bnkseek.setRkc(mapEntry.getValue().get("RKC").toString());
            bnkseek.setNamep(mapEntry.getValue().get("NAMEP").toString().trim());
            bnkseek.setNewnum(mapEntry.getValue().get("NEWNUM").toString());
            bnkseek.setTelef(mapEntry.getValue().get("TELEF").toString().trim());
            bnkseek.setRegn(mapEntry.getValue().get("REGN").toString().trim());
            bnkseek.setOkpo(mapEntry.getValue().get("OKPO").toString());
            bnkseek.setDtIzm((Date) mapEntry.getValue().get("DT_IZM"));
            bnkseek.setKsnp(mapEntry.getValue().get("KSNP").toString().trim());
            bnkseek.setDateIn((Date)mapEntry.getValue().get("DATE_IN"));
            bnkseek.setDateCh((Date) mapEntry.getValue().get("DATE_CH"));
            bnkseekList.add(bnkseek);
        }
        bnkseekRepo.save(bnkseekList);
    }

    public List<BnkseekEntity> returnAll() {
       return  bnkseekRepo.findAll();
    }

    public List<PznEntity> returnPzn(){ return pznRepo.findAll();}

    public List<BnkseekEntity> returnByBIKFilter(String bikField) {
        return bnkseekRepo.findByNewnum(bikField);
    }

    public List<BnkseekEntity> returnByBikRegion(String bikRegion) {
        return bnkseekRepo.findByRgnName(bikRegion);
    }

    public List<BnkseekEntity> returnByPznType(String bikPznType) {
        return bnkseekRepo.findByPznVkey(bikPznType);
    }

    public BnkseekEntity returnOneBnkseek(long id) {
        return bnkseekRepo.findOne(id);
    }

    public TnpEntity returnOneTnp(String vkey){return tnpRepo.findOne(vkey);}

    public boolean deleteBnkseek(long id) {
        bnkseekRepo.delete(id);
        return true;
    }

    public List<RealyEntity> returnRealy() {
        return realyRepo.findAll();
    }

    public List<RegEntity> returnReg() {
        return  regRepo.findAll();
    }

    public List<TnpEntity> returnTnp() {
        return tnpRepo.findAll();
    }

    public List<UerEntity> returnUer() {
        return uerRepo.findAll();
    }

    public void saveBnkseek(BnkseekEntity bnkseek) {
        bnkseekRepo.save(bnkseek);
    }

    public UerEntity returnOneUer(String bikUerType) {
       return  uerRepo.findOne(bikUerType);
    }

    public PznEntity returnOnePzn(String bikPznType) {
        return pznRepo.findOne(bikPznType);
    }

    public RealyEntity returnOneRealy(String bikRealyType) {
        return realyRepo.findOne(bikRealyType);
    }

    public RegEntity returnOneRgn(String bikRegType) {
        return regRepo.findOne(bikRegType);
    }
}
