package com.centrabank.bik.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "pzn", schema = "bigbik")
public class PznEntity {
    private String vkey;
    private String imy;
    private String name;
    private String pzn;

    @Id
    @Column(name = "vkey")
    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    @Basic
    @Column(name = "imy")
    public String getImy() {
        return imy;
    }

    public void setImy(String imy) {
        this.imy = imy;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pzn")
    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PznEntity pznEntity = (PznEntity) o;

        if (vkey != null ? !vkey.equals(pznEntity.vkey) : pznEntity.vkey != null) return false;
        if (imy != null ? !imy.equals(pznEntity.imy) : pznEntity.imy != null) return false;
        if (name != null ? !name.equals(pznEntity.name) : pznEntity.name != null) return false;
        if (pzn != null ? !pzn.equals(pznEntity.pzn) : pznEntity.pzn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vkey != null ? vkey.hashCode() : 0;
        result = 31 * result + (imy != null ? imy.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pzn != null ? pzn.hashCode() : 0);
        return result;
    }
}
