package com.Mappings;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "collegeInfo")
public class College {

    @Id
    private int collegeId;

    private String clgName;
    private String clgLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_number")
    private License license;

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public String getClgLocation() {
        return clgLocation;
    }

    public void setClgLocation(String clgLocation) {
        this.clgLocation = clgLocation;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
