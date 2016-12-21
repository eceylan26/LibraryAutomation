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

public class MySQL_1 {
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {      
        int result;
        int choice;
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mylibrary"; 
        String kullaniciad = "root";
        String sifre = ""; 

        Connection con = null;
        Statement st = null; 
        
        con = DriverManager.getConnection(url, kullaniciad, sifre);
        st = con.createStatement();
        String sql;
        
        Scanner scan = new Scanner(System.in);
        String userName = null;
        int password = 0;
        
        System.err.println("*** WELCOME TO LIBRARY AUTOMATİON ***");
        System.err.println("Username:");
        userName=scan.next();
                       
        System.err.println("Password:");
        password=scan.nextInt();
        
        while(true)
        {      
            result=isMember(userName,password);
            
            if(result==1)
            {
                Admin myAdmin=new Admin(userName,password);
                
                while(true)
                {
                    myAdmin.Menu();
                    
                    System.err.print("Choice >> ");
                    choice=scan.nextInt();
                    
                    switch (choice)
                    {
                        case 1:
                            myAdmin.addUser();
                            break;
                        case 2:
                            myAdmin.addBook();
                            break;
                        case 3:
                            myAdmin.listAllAcc();
                            break;
                        case 4:
                            myAdmin.listAllBooks();
                            break;
                        case 5:
                            myAdmin.deleteMember();
                            break;
                        case 6:
                            myAdmin.deleteBook();
                            break;
                        case 7:
                            System.exit(1);
                        default:
                            System.err.println("Wrong choice Try again !!\n");
                            break;
                    }
                    
                }

            }
            else if(result==0)
            {
                Member member = new Member(userName,password);
                member.Menu();
                
                while(true)
                {
                    System.err.print("Choice >> ");
                    choice=scan.nextInt();
                    
                    switch (choice)
                    {
                        case 1:
                            member.listAllMyBooks();
                            break;
                        case 2:
                            member.searchBook();
                            break;
                        case 3:
                            member.borrowBook();
                            break;
                        case 4:
                            member.commentBook();
                            break;
                        case 5:
                            System.exit(1);
                            break;
                        default:
                            System.err.println("Wrong choice Try again !!\n");
                            break;
                    }
                    
                }

            }
            else
            {
                System.out.println("You Entered Wrong Username or Password !!! "); 
                break;
            }
   
        }


        //Admin myAdmin=new Admin("erso", 1111, "admin", "admin", 326046168, "sbecerikli@gmail.com", "male");
        //Member member1 = new Member("buse23", 1234, "buse", "guner", 32656262, "buse@gmail.com", "female");
        

        /*sql = "CREATE TABLE Members " +
                   "(username VARCHAR(255), " +
                   " password INTEGER, " + 
                   " name VARCHAR(255), " + 
                   " surname VARCHAR(255), " + 
                   " tel INTEGER(20), " + 
                   " email VARCHAR(255), " +
                   " gender VARCHAR(10), " +
                   " PRIMARY KEY ( username ))"; 

        st.executeUpdate(sql);
          
        sql = "CREATE TABLE Books " +
                   "(bookId INTEGER NOT NULL AUTO_INCREMENT, " +
                   " bookname VARCHAR(255), " + 
                   " author VARCHAR(255), " + 
                   " availability TINYINT(1)," +
                   " PRIMARY KEY ( bookId ))"; 
        
        st.executeUpdate(sql);
        
        sql = "CREATE TABLE BorrowRel " +
                   "(UserName VARCHAR(255)," +
                   " bookid INTEGER not NULL)," +
                   " comments VARCHAR(255)" ;
        
        st.executeUpdate(sql);*/
}
    
    public static int isMember(String userName,int password) throws ClassNotFoundException, SQLException
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
        
        ResultSet rs = st.executeQuery("SELECT userName,password FROM Members");
        
        while (rs.next())
        {
            String uss = rs.getString("userName");
            int pass = rs.getInt("password");
            
            if(uss.equals(userName)==true && pass==password)
            {
                if(uss.equals("admin"))
                {
                    return 1;
                }
                
                return 0;
            }
        }

        return -1;
    }  
}
