package com.centrabank.bik.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "reg", schema = "bigbik", catalog = "")
public class RegEntity {
    private String vkey;
    private String rgn;
    private String name;

    @Id
    @Column(name = "vkey")
    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    @Basic
    @Column(name = "rgn")
    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegEntity regEntity = (RegEntity) o;

        if (vkey != null ? !vkey.equals(regEntity.vkey) : regEntity.vkey != null) return false;
        if (rgn != null ? !rgn.equals(regEntity.rgn) : regEntity.rgn != null) return false;
        if (name != null ? !name.equals(regEntity.name) : regEntity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vkey != null ? vkey.hashCode() : 0;
        result = 31 * result + (rgn != null ? rgn.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
