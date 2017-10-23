package com.centrabank.bik.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "uer", schema = "bigbik")
public class UerEntity {
    private String vkey;
    private String uer;
    private String uername;

    @Id
    @Column(name = "vkey")
    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    @Basic
    @Column(name = "uer")
    public String getUer() {
        return uer;
    }

    public void setUer(String uer) {
        this.uer = uer;
    }

    @Basic
    @Column(name = "uername")
    public String getUername() {
        return uername;
    }

    public void setUername(String uername) {
        this.uername = uername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UerEntity uerEntity = (UerEntity) o;

        if (vkey != null ? !vkey.equals(uerEntity.vkey) : uerEntity.vkey != null) return false;
        if (uer != null ? !uer.equals(uerEntity.uer) : uerEntity.uer != null) return false;
        if (uername != null ? !uername.equals(uerEntity.uername) : uerEntity.uername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vkey != null ? vkey.hashCode() : 0;
        result = 31 * result + (uer != null ? uer.hashCode() : 0);
        result = 31 * result + (uername != null ? uername.hashCode() : 0);
        return result;
    }
}
