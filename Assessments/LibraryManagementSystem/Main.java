package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = context.getBean(BookService.class);
        MemberService memberService = context.getBean(MemberService.class);
        LibraryService libraryService = context.getBean(LibraryService.class);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Member");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Member ID: ");
                    Long memberId = sc.nextLong();
                    sc.nextLine(); 
                    System.out.print("Enter Member Name: ");
                    String memberName = sc.nextLine();
                    System.out.print("Enter Member Email: ");
                    String memberEmail = sc.nextLine();
                    memberService.registerMember(memberId, memberName, memberEmail);
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    Long bookId = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    bookService.addBook(bookId, title, author);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    Long issueMemberId = sc.nextLong();
                    System.out.print("Enter Book ID: ");
                    Long issueBookId = sc.nextLong();
                    libraryService.issueBook(issueMemberId, issueBookId);
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    Long returnMemberId = sc.nextLong();
                    System.out.print("Enter Book ID: ");
                    Long returnBookId = sc.nextLong();
                    libraryService.returnBook(returnMemberId, returnBookId);
                    break;
                case 5:
                    System.out.println("\nAvailable Books:");
                    bookService.getAvailableBooks()
                            .forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        } while (choice != 6);
        sc.close();
    }
}
