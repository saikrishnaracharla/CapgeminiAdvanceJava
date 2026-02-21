package com.CrmSales;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderService {
    public void placeOrder(Long customerId, List<Long> productIds) {
        Session s = CrmSalesUtility.getSf().openSession();
        Transaction t = s.beginTransaction();
        Customer customer = s.get(Customer.class, customerId);
        if (customer == null) {
            System.out.println("Customer Not Found");
            s.close();
            return;
        }
        List<Product> products = new ArrayList<>();
        double total = 0;
        for (Long id : productIds) {
            Product p = s.get(Product.class, id);
            if (p != null) {
                products.add(p);
                total += p.getPrice();
            }
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setTotalAmount(total);
        order.setOrderDate(java.time.LocalDate.now().toString());

        s.save(order);

        t.commit();
        s.close();

        System.out.println("Order Placed Successfully");
        System.out.println("Total Amount: " + total);
    }
}
