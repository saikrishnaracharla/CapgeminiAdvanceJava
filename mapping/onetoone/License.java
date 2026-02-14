package com.Mappings;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "license")
public class License {

    @Id
    private int licenseNumber;

    private String licenseHolderName;
    private String validateUpto;

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseHolderName() {
        return licenseHolderName;
    }

    public void setLicenseHolderName(String licenseHolderName) {
        this.licenseHolderName = licenseHolderName;
    }

    public String getValidateUpto() {
        return validateUpto;
    }

    public void setValidateUpto(String validateUpto) {
        this.validateUpto = validateUpto;
    }
}
