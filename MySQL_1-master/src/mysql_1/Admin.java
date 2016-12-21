/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buse
 */
public class Admin extends User implements AdminPermissions
{
    
    public Admin(String username, int password) 
    {
        super(username, password);
    }

    @Override
    public String addUser() 
    {
        StringBuilder str = new StringBuilder();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
   
        try 
        {
            con = DriverManager.getConnection(url, kullaniciad, sifre);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Scanner scan = new Scanner(System.in);
        
        String userName = null;
        String name = null;
        String surname = null;
        String gender = null;
        String email = null;
        int password = 0;
        int telefon=0;
        
        System.err.println("Username >> ");
        userName=scan.next();
        System.err.println("Password >> ");
        password=scan.nextInt();
        System.err.println("Name >>");
        name=scan.next();
        System.err.println("SurName >>");
        surname=scan.next();
        System.err.println("Telefon >> ");
        telefon=scan.nextInt();
        System.err.println("Email >> ");
        email=scan.next();
        System.err.println("Gender >> ");
        gender=scan.next();
        
        
        str.append("INSERT INTO Members VALUES (");
        str.append("'" + userName + "', ");
        str.append(password + ", ");
        str.append("'" + name + "', ");
        str.append("'" + surname + "', ");
        str.append(telefon + ", ");
        str.append("'" + email + "', ");
        str.append("'" + gender +"' )");
        
        try {
            st.executeUpdate(str.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str.toString();
    }

    @Override
    public String addBook() 
    {
        StringBuilder str = new StringBuilder();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
   
        try 
        {
            con = DriverManager.getConnection(url, kullaniciad, sifre);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scanner scan = new Scanner(System.in);
        
        String bookName = null;
        String author = null;
        String comments = null;
        int bookId=0;
        int availability=0;
 
        System.err.println("bookId >> ");
        bookId=scan.nextInt();
        System.err.println("bookname >> ");
        bookName=scan.next();
        System.err.println("author >>");
        author=scan.next();

        str.append("INSERT INTO Books VALUES (");
        str.append(bookId + ", ");
        str.append("'" + bookName + "', ");
        str.append("'" + author + "', ");
        str.append(1 + ", ");
        str.append("'" + " " + "' ) ");
        
        try {
            st.executeUpdate(str.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return str.toString();
    }
    
    public void Menu() 
    {
        System.out.println();
        System.out.println("*********** MENU ************");
        System.out.println("1- Register a new member     ");
        System.out.println("2- Register a new book       ");
        System.out.println("3- List all accounts         ");
        System.out.println("4- List all books            ");
        System.out.println("5- Delete a member           ");
        System.out.println("6- Delete a book             ");
        System.out.println("7- Exit                      ");
        
    }
    
    
    public void listAllAcc() throws ClassNotFoundException, SQLException 
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
   
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        

        System.out.println("\nUsername - Password - Name - Surname - Tel - Email - Gender");
        System.out.println("----------------------------------------------------------------------");
        ResultSet rs = st.executeQuery("SELECT * FROM Members");
        
        while (rs.next())
        {
            System.out.print(rs.getString("userName"));
            System.out.print(" | ");
            System.out.print(rs.getString("password"));
            System.out.print(" | ");
            System.out.print(rs.getString("name"));
            System.out.print(" | ");
            System.out.print(rs.getString("surname"));
            System.out.print(" | ");
            System.out.print(rs.getString("tel"));
            System.out.print(" | ");
            System.out.print(rs.getString("email"));
            System.out.print(" | ");
            System.out.print(rs.getString("gender"));
            System.out.println();
        }

    }
    
    
    public void listAllBooks() throws ClassNotFoundException, SQLException 
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
   
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        ResultSet rs = st.executeQuery("SELECT * FROM Books");
        
        System.out.println("\nBookid - Bookname - Author - Availability");
        System.out.println("----------------------------------------------");
        
        while (rs.next())
        {
            System.out.print(rs.getString("bookId"));
            System.out.print(" | ");
            System.out.print(rs.getString("bookname"));
            System.out.print(" | ");
            System.out.print(rs.getString("author"));
            System.out.print(" | ");
            System.out.print(rs.getString("availability"));
            System.out.println(" ");
        }

    }
    
    public void deleteMember() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
        StringBuilder str = new StringBuilder();
           
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        Scanner scan = new Scanner(System.in);
        
        String userName = null;

        System.err.println("UserName >> ");
        userName=scan.next();
        
        str.append("DELETE FROM members WHERE username=");
        str.append("'"+userName + "'");
        
        if(isInMember(userName)==1)
        {
            st.executeUpdate(str.toString());  
        }
        else
            System.out.println("There is no member like that");
    }
    
    public void deleteBook() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
        StringBuilder str = new StringBuilder();
           
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        Scanner scan = new Scanner(System.in);
        
        int bookId;

        System.err.println("BookId >> ");
        bookId=scan.nextInt();
        
        str.append("DELETE FROM books WHERE bookid=");
        str.append("'"+ bookId + "'");
        
        if(existBookId(bookId)==1)
        {
            st.executeUpdate(str.toString());
        }
        else
            System.out.println("There is no book about bookId");
        
    }
    
    private int isInMember(String userName) throws ClassNotFoundException, SQLException
    {
        StringBuilder str = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        
        boolean check = false;
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null;
            
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        str.append("SELECT * FROM members WHERE username=");
        str.append("'"+ userName + "'");
        
        ResultSet rs = st.executeQuery(str.toString());

        while (rs.next())
        {
           return 1;
        }
              
        return -1;
    }
    
    public int existBookId(int bookId) throws ClassNotFoundException, SQLException
    {
        StringBuilder str = new StringBuilder();
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
        
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        
        str.append("SELECT bookid FROM books WHERE bookId=");
        str.append(bookId);
        
        ResultSet rs = st.executeQuery(str.toString());

        while (rs.next())
        {
            return 1;
        }
        
        return -1;
        
    }
}
