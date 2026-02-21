package com.CrmSales;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductService {
    public void addProduct(String name, double price) {
        Session s = CrmSalesUtility.getSf().openSession();
        Transaction t = s.beginTransaction();
        Product p = new Product();
        p.setProductName(name);
        p.setPrice(price);

        s.save(p);

        t.commit();
        s.close();

        System.out.println("Product Added Successfully");
    }
}
