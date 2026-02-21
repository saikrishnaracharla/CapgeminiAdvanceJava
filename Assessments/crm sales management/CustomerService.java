package com.CrmSales;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {
    public void registerCustomer(String name, String email, String phone) {
        Session s = CrmSalesUtility.getSf().openSession();
        Transaction t = s.beginTransaction();
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);
        s.save(c);
        t.commit();
        s.close();

        System.out.println("Customer Registered Successfully");
    }
    public void updateCustomer(Long id, String phone) {

        Session s = CrmSalesUtility.getSf().openSession();
        Transaction t = s.beginTransaction();

        Customer c = s.get(Customer.class, id);

        if (c != null) {
            c.setPhone(phone);
            s.update(c);
            System.out.println("Customer Updated Successfully");
        } else {
            System.out.println("Customer Not Found");
        }

        t.commit();
        s.close();
    }
    public void deleteCustomer(Long id) {
        Session s = CrmSalesUtility.getSf().openSession();
        Transaction t = s.beginTransaction();

        Customer c = s.get(Customer.class, id);
        if (c != null) {
            s.delete(c);
            System.out.println("Customer Deleted Successfully");
        } else {
            System.out.println("Customer Not Found");
        }

        t.commit();
        s.close();
    }
}
