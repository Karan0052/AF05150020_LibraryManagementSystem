package com.lib;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    dao.addBook(new Book(title, author, "Available"));
                    break;

                case 2:
                    List<Book> list = dao.getAllBooks();
                    System.out.println("\n--- Book List ---");
                    for (Book b : list) {
                        System.out.println(
                                b.getId() + " | " +
                                b.getTitle() + " | " +
                                b.getAuthor() + " | " +
                                b.getStatus()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    dao.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    dao.returnBook(returnId);
                    break;

                case 5:
                    System.out.print("Enter Book ID to Delete: ");
                    int delId = sc.nextInt();
                    dao.deleteBook(delId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}