package com.Mappings;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClgLicenseRealtion {

    public static void main(String[] args) {

        Session s = OneToOneUtility.getSf().openSession();
        Transaction t = s.beginTransaction();

        License l = new License();
        l.setLicenseNumber(123121);
        l.setLicenseHolderName("Krishna");
        l.setValidateUpto("4/march/2028");

        College c = new College();
        c.setCollegeId(9821);
        c.setClgName("LPU");
        c.setClgLocation("Chaheru");

        // IMPORTANT: Linking objects
        c.setLicense(l);

        s.save(c);   // Cascade will save License also

        t.commit();
        s.close();

        System.out.println("done");
    }
}
