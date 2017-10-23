package com.centrabank.bik.server.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bnkseek", schema = "bigbik")
public class BnkseekEntity {
    private long id;
    private String ind;
    private String nnp;
    private String bnkseekcol;
    private String addr;
    private String rkc;
    private String namep;
    private String newnum;
    private String telef;
    private String regn;
    private String okpo;
    private Date dtIzm;
    private String ksnp;
    private Date dateIn;
    private Date dateCh;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ind")
    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    @Basic
    @Column(name = "nnp")
    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    @Basic
    @Column(name = "bnkseekcol")
    public String getBnkseekcol() {
        return bnkseekcol;
    }

    public void setBnkseekcol(String bnkseekcol) {
        this.bnkseekcol = bnkseekcol;
    }

    @Basic
    @Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "rkc")
    public String getRkc() {
        return rkc;
    }

    public void setRkc(String rkc) {
        this.rkc = rkc;
    }

    @Basic
    @Column(name = "namep")
    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    @Basic
    @Column(name = "newnum", unique = true)
    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
    }

    @Basic
    @Column(name = "telef")
    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    @Basic
    @Column(name = "regn")
    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn;
    }

    @Basic
    @Column(name = "okpo")
    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    @Basic
    @Column(name = "dt_izm")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Date getDtIzm() {
        return dtIzm;
    }

    public void setDtIzm(Date dtIzm) {
        this.dtIzm = dtIzm;
    }

    @Basic
    @Column(name = "ksnp")
    public String getKsnp() {
        return ksnp;
    }

    public void setKsnp(String ksnp) {
        this.ksnp = ksnp;
    }

    @Basic
    @Column(name = "date_in")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @Basic
    @Column(name = "date_ch")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Date getDateCh() {
        return dateCh;
    }

    public void setDateCh(Date dateCh) {
        this.dateCh = dateCh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BnkseekEntity that = (BnkseekEntity) o;

        if (id != that.id) return false;
        if (ind != null ? !ind.equals(that.ind) : that.ind != null) return false;
        if (nnp != null ? !nnp.equals(that.nnp) : that.nnp != null) return false;
        if (bnkseekcol != null ? !bnkseekcol.equals(that.bnkseekcol) : that.bnkseekcol != null) return false;
        if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;
        if (rkc != null ? !rkc.equals(that.rkc) : that.rkc != null) return false;
        if (namep != null ? !namep.equals(that.namep) : that.namep != null) return false;
        if (newnum != null ? !newnum.equals(that.newnum) : that.newnum != null) return false;
        if (telef != null ? !telef.equals(that.telef) : that.telef != null) return false;
        if (regn != null ? !regn.equals(that.regn) : that.regn != null) return false;
        if (okpo != null ? !okpo.equals(that.okpo) : that.okpo != null) return false;
        if (dtIzm != null ? !dtIzm.equals(that.dtIzm) : that.dtIzm != null) return false;
        if (ksnp != null ? !ksnp.equals(that.ksnp) : that.ksnp != null) return false;
        if (dateIn != null ? !dateIn.equals(that.dateIn) : that.dateIn != null) return false;
        if (dateCh != null ? !dateCh.equals(that.dateCh) : that.dateCh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 31 * result + (ind != null ? ind.hashCode() : 0);
        result = 31 * result + (nnp != null ? nnp.hashCode() : 0);
        result = 31 * result + (bnkseekcol != null ? bnkseekcol.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (rkc != null ? rkc.hashCode() : 0);
        result = 31 * result + (namep != null ? namep.hashCode() : 0);
        result = 31 * result + (newnum != null ? newnum.hashCode() : 0);
        result = 31 * result + (telef != null ? telef.hashCode() : 0);
        result = 31 * result + (regn != null ? regn.hashCode() : 0);
        result = 31 * result + (okpo != null ? okpo.hashCode() : 0);
        result = 31 * result + (dtIzm != null ? dtIzm.hashCode() : 0);
        result = 31 * result + (ksnp != null ? ksnp.hashCode() : 0);
        result = 31 * result + (dateIn != null ? dateIn.hashCode() : 0);
        result = 31 * result + (dateCh != null ? dateCh.hashCode() : 0);
        return result;
    }

    private PznEntity pzn;


    @ManyToOne
    public PznEntity getPzn() {
        return pzn;
    }

    public void setPzn(PznEntity pzn) {
        this.pzn = pzn;
    }

    private RealyEntity realy;

    @ManyToOne
    public RealyEntity getRealy() {
        return realy;
    }

    public void setRealy(RealyEntity realy) {
        this.realy = realy;
    }

    private UerEntity uer;

    @ManyToOne
    public UerEntity getUer() {
        return uer;
    }

    public void setUer(UerEntity uer) {
        this.uer = uer;
    }

    private TnpEntity tnp;

    @ManyToOne
    public TnpEntity getTnp() {
        return tnp;
    }

    public void setTnp(TnpEntity tnp) {
        this.tnp = tnp;
    }

    private RegEntity rgn;

    @ManyToOne
    public RegEntity getRgn() {
        return rgn;
    }

    public void setRgn(RegEntity rgn) {
        this.rgn = rgn;
    }
}
