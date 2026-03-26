package com.lib;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // ADD BOOK
    public void addBook(Book b) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO books(title, author, status) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getStatus());

            ps.executeUpdate();
            System.out.println("✅ Book Added");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // VIEW BOOKS
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    // ISSUE BOOK
    public void issueBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE books SET status='Issued' WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("📕 Book Issued");
            else
                System.out.println("❌ Book Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // RETURN BOOK
    public void returnBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE books SET status='Available' WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("📗 Book Returned");
            else
                System.out.println("❌ Book Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE BOOK
    public void deleteBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("🗑️ Book Deleted");
            else
                System.out.println("❌ Book Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}