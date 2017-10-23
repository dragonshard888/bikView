package com.centrabank.bik.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "tnp", schema = "bigbik")
public class TnpEntity {
    private String vkey;
    private String tnp;
    private String fullname;
    private String shortname;

    @Id
    @Column(name = "vkey")
    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    @Basic
    @Column(name = "tnp")
    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    @Basic
    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "shortname")
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TnpEntity tnpEntity = (TnpEntity) o;

        if (vkey != null ? !vkey.equals(tnpEntity.vkey) : tnpEntity.vkey != null) return false;
        if (tnp != null ? !tnp.equals(tnpEntity.tnp) : tnpEntity.tnp != null) return false;
        if (fullname != null ? !fullname.equals(tnpEntity.fullname) : tnpEntity.fullname != null) return false;
        if (shortname != null ? !shortname.equals(tnpEntity.shortname) : tnpEntity.shortname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vkey != null ? vkey.hashCode() : 0;
        result = 31 * result + (tnp != null ? tnp.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (shortname != null ? shortname.hashCode() : 0);
        return result;
    }
}
