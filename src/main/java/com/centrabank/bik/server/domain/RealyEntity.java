package com.centrabank.bik.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "realy", schema = "bigbik")
public class RealyEntity {
    private String vkey;
    private String realy;
    private String nameOgr;

    @Id
    @Column(name = "vkey")
    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    @Basic
    @Column(name = "realy")
    public String getRealy() {
        return realy;
    }

    public void setRealy(String realy) {
        this.realy = realy;
    }

    @Basic
    @Column(name = "name_ogr")
    public String getNameOgr() {
        return nameOgr;
    }

    public void setNameOgr(String nameOgr) {
        this.nameOgr = nameOgr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RealyEntity that = (RealyEntity) o;

        if (vkey != null ? !vkey.equals(that.vkey) : that.vkey != null) return false;
        if (realy != null ? !realy.equals(that.realy) : that.realy != null) return false;
        if (nameOgr != null ? !nameOgr.equals(that.nameOgr) : that.nameOgr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vkey != null ? vkey.hashCode() : 0;
        result = 31 * result + (realy != null ? realy.hashCode() : 0);
        result = 31 * result + (nameOgr != null ? nameOgr.hashCode() : 0);
        return result;
    }
}
