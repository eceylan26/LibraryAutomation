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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buse
 */
public class Member extends User implements MemberPermissions
{
    
    public Member(String username, int password) 
    {
        super(username, password);
    }

    @Override
    public void borrowBook()
    {
        int bookId;
        
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
        
        String bookName=null;
        Scanner scan = new Scanner(System.in);
        
        System.err.println("BookName >> ");
        bookName=scan.nextLine();
        
        try {
            con = DriverManager.getConnection(url, kullaniciad, sifre);
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            if(isInBook(bookName)==1)
            {          
                bookId=findBookId(bookName);            
                StringBuilder str1 = new StringBuilder();
        
                str1.append("INSERT INTO BorrowRel VALUES (");
                str1.append("'"+ userName + "', ");
                str1.append(bookId + ",");
                str1.append("'" + "-" + "')");

                st.executeUpdate(str1.toString());  
                System.out.printf("'%s' that book succesfully added.\n",bookName);
                
                str2.append("UPDATE books SET availability=0 ");
                str2.append("WHERE bookname=");
                str2.append("'"+ bookName + "'");
                
                st.executeUpdate(str2.toString());
                
            }
            else if(isInBook(bookName)==0)
            {
                System.out.printf("'%s' that book is not available now. Sorry,try later.\n",bookName);
            }
            else
            {
                System.out.printf("'%s' that book is not in library.\n",bookName);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public void listAllMyBooks() throws ClassNotFoundException, SQLException
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

        str.append("SELECT B1.bookid,B2.bookname,B1.comment FROM BorrowRel B1,books B2 WHERE B1.username=");
        str.append("'"+ userName + "' AND B1.bookid=B2.bookid");
        
        ResultSet rs = st.executeQuery(str.toString());
        
        System.out.println("\nBookid - Bookname - Comment");
        System.out.println("-----------------------------");
        
        while (rs.next())
        {
            System.out.print(rs.getString("bookid"));
            System.out.print(" | ");
            
            System.out.print(rs.getString("bookname"));
            System.out.print(" | ");

            System.out.print(rs.getString("comment"));
            System.out.println(" ");
        }
 
    }
    
    public void searchBook() throws ClassNotFoundException, SQLException
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
        
        String bookName=null;
        
        Scanner scan = new Scanner(System.in);
        
        System.err.println("BookName >> ");
        bookName=scan.nextLine();

        str.append("SELECT * FROM books WHERE bookname=");
        str.append("'"+ bookName + "'");
        
        ResultSet rs = st.executeQuery(str.toString());
        
        while (rs.next())
        {
            System.out.println("\nBookid - Bookname - Author - Availability");
            System.out.println("----------------------------------------------");
            
            check=true;
            
            System.out.print(rs.getString("bookid"));
            System.out.print(" | ");
            
            System.out.print(rs.getString("bookname"));
            System.out.print(" | ");
            
            System.out.print(rs.getString("author"));
            System.out.print(" | ");

            System.out.print(rs.getString("availability"));
            System.out.println(" ");
        }
 
        if(check==false)
        {
            System.out.println("There is no book for your search in our library !!");
        }
        
    }    
    
    private int isInBook(String bookName) throws ClassNotFoundException, SQLException
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
        
        str.append("SELECT * FROM books WHERE bookname=");
        str.append("'"+ bookName + "'");
        
        ResultSet rs = st.executeQuery(str.toString());

        while (rs.next())
        {
            if(rs.getString("availability").equals("1"))
            {
                return 1;
            }
            else
                return 0;
        }
        
        
        return -1;
    }
    
    
    public int findBookId(String bookName) throws ClassNotFoundException, SQLException
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
        
        
        str.append("SELECT bookid FROM books WHERE bookname=");
        str.append("'"+ bookName + "'");
        
        ResultSet rs = st.executeQuery(str.toString());

        while (rs.next())
        {
        
            return Integer.parseInt(rs.getString("bookid"));
        }
        
        return -1;
        
    }
    
    public void commentBook() throws ClassNotFoundException, SQLException
    {
        StringBuilder str = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        
        String comment;
        boolean check = false;
        ArrayList<Integer> commentBooks = new ArrayList<Integer>();
        int i=0;
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null;
            
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        str.append("SELECT B1.bookid,B2.bookname FROM BorrowRel B1,books B2 WHERE B1.username=");
        str.append("'"+ userName + "' AND B1.comment= '-' AND B1.bookid=B2.bookid");
       
        ResultSet rs = st.executeQuery(str.toString());
        
        System.out.println("\nBookid - Bookname ");
        System.out.println("--------------------");

        while (rs.next())
        {
            check=true;
            
            System.err.print(rs.getString("bookid"));
            commentBooks.add(Integer.parseInt(rs.getString("bookid")));
            System.err.print(" | ");
            
            System.err.print(rs.getString("bookname"));
            System.err.println(" | ");
            i++;
        }
 
        if(check==false)
        {
            System.out.println("All of books already were commented or you have not books in system !!");
            return;
        }

        Scanner scan = new Scanner(System.in);
        check=false;
        int bookId;
        i=0;

        while(true)
        { 
            System.err.println("Choice BookId >> ");
            bookId=scan.nextInt();
            
            while(i<commentBooks.size())
            {
                if(commentBooks.get(i)==bookId)
                {
                    check=true;
                    break;
                }

                i++;
            }   
            
            if(check==true)
            {
                break;
            }
            
            i=0;
        }
        
        comment=scan.nextLine();
        System.err.println("Comment >> ");
        comment=scan.nextLine();
        
        
        str1.append("UPDATE BorrowRel SET comment=");
        str1.append("'"+ comment + "' ");
        str1.append("WHERE bookid=");
        str1.append(bookId);
        
        st.executeUpdate(str1.toString());
        
        
        str2.append("UPDATE books SET availability=1 ");
        str2.append("WHERE bookid=");
        str2.append(bookId);

        st.executeUpdate(str2.toString());
      
    }    
    
    @Override
    public void Menu() 
    {
        System.out.println("*********** MENU ************");
        System.out.println("1- List all my books         ");
        System.out.println("2- Search a book             ");
        System.out.println("3- Borrow a book             ");
        System.out.println("4- Comment a book            ");
        System.out.println("5- Exit                      ");
    }
}
