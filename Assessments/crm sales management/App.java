package com.CrmSales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args ) {
    	 Scanner sc = new Scanner(System.in);

         CustomerService customerService = new CustomerService();
         ProductService productService = new ProductService();
         OrderService orderService = new OrderService();

         int choice;

         do {
             System.out.println("----- CRM MENU -----");
             System.out.println("1. Register Customer");
             System.out.println("2. Update Customer");
             System.out.println("3. Delete Customer");
             System.out.println("4. Add Product");
             System.out.println("5. Place Order");
             System.out.println("6. Exit");

             choice = sc.nextInt();

             switch (choice) {

                 case 1:
                     System.out.println("Enter Name:");
                     String name = sc.next();
                     System.out.println("Enter Email:");
                     String email = sc.next();
                     System.out.println("Enter Phone:");
                     String phone = sc.next();

                     customerService.registerCustomer(name, email, phone);
                     break;

                 case 2:
                     System.out.println("Enter Customer ID:");
                     Long id = sc.nextLong();
                     System.out.println("Enter New Phone:");
                     String newPhone = sc.next();
                     customerService.updateCustomer(id, newPhone);
                     break;

                 case 3:
                     System.out.println("Enter Customer ID:");
                     Long delId = sc.nextLong();
                     customerService.deleteCustomer(delId);
                     break;

                 case 4:
                     System.out.println("Enter Product Name:");
                     String pname = sc.next();
                     System.out.println("Enter Price:");
                     double price = sc.nextDouble();
                     productService.addProduct(pname, price);
                     break;

                 case 5:
                     System.out.println("Enter Customer ID:");
                     Long custId = sc.nextLong();

                     System.out.println("How many products?");
                     int count = sc.nextInt();

                     List<Long> productIds = new ArrayList<>();
                     for (int i = 0; i < count; i++) {
                         System.out.println("Enter Product ID:");
                         productIds.add(sc.nextLong());
                     }

                     orderService.placeOrder(custId, productIds);
                     break;

                 case 6:
                     System.out.println("Exiting...");
                     break;

                 default:
                     System.out.println("Invalid Choice");
             }

         } while (choice != 6);

         sc.close();
         CrmSalesUtility.getSf().close();
     }

}

