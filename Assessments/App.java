package com.lpu.HotelManagement;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Employee.EmpDetails;

public class App{
	
	
    public static void main( String[] args ) {
    	Scanner sc=new Scanner(System.in);
    	int choice =0;
do {
    	System.out.println("******GREETINGS CUSTOMERS*****");
    	System.out.println("1.select 1 for adding customers details");
    	System.out.println("2.select 2 to view customer details");
    	System.out.println("3.seelct 3 to update customer details");
    	System.out.println("4.selct 4 for delete customer details");
    	System.out.println("5.to Exit...");
    	
    	try {
    		choice=sc.nextInt();
    	}catch(Exception e) {
    		System.out.println("invalid input");
    		sc.next();
    		continue;
    	}
    	if(choice==5) {
    		break;
    	}
    	Session s=HotelManagementUtility.getSf().openSession();
    	Transaction t=s.beginTransaction();
    	
    	try {
    		if(choice==1) {
    			sc.nextLine();
    			Booking b=new Booking();
    			System.out.println("enter customer name");
    			b.setCustomerName(sc.next());
    			System.out.println("enter roomType (standard/deluxe/suite)");
    			b.setRoomType(sc.next());
    			System.out.println("enter number of days you want to stay");
    			b.setStayDays(sc.nextInt());
    			b.calculateTotalAmt();
    			
    			s.save(b);
    			t.commit();
    			System.out.println("customer saved sucessfully");	
    		} else if(choice==2) {
    			 System.out.println("Enter customer id");
                 int customerId = sc.nextInt();
                 Booking b = s.get(Booking.class, customerId);
                 if (b != null) {
                     System.out.println(b.getBookingId()+" "+b.getCustomerName()+" "+b.getRoomType()+" "+b.getStayDays()+" "
                    		 +b.getTotalAmount());
                 } else {
                     System.out.println("customer not found");
                 } 
    		} else if (choice == 3) {
    		    System.out.println("Enter Booking ID to update:");
    		    int id = sc.nextInt();
    		    Booking b = s.get(Booking.class, id);
    		    if (b != null) {
    		        sc.nextLine();
    		        System.out.println("Enter Updated Customer Name:");
    		        b.setCustomerName(sc.nextLine());
    		        System.out.println("Enter Updated Room Type (Standard/Deluxe/Suite)");
    		        b.setRoomType(sc.next());
    		        System.out.println("Enter Updated Stay Days");
    		        b.setStayDays(sc.nextInt());
    		        b.calculateTotalAmt();

    		        s.update(b);
    		        t.commit();

    		        System.out.println("Booking Updated Successfully");
    		    } else {
    		        System.out.println("Booking Not Found");
    		    }
    		}else if (choice == 4) {
    		    System.out.println("Enter Booking ID to delete");
    		    int id = sc.nextInt();
    		    Booking b = s.get(Booking.class, id);
    		    if (b != null) {
    		        s.delete(b);
    		        t.commit();
    		        System.out.println("Booking Deleted Successfully");
    		    } else {
    		        System.out.println("Booking Not Found");
    		    }
    		}
    	}catch(Exception e) {
    		System.out.println("invalid choice");
    	}
} while(choice!=5);
    }
}
