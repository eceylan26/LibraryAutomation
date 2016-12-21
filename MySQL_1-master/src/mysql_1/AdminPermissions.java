/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_1;

import java.sql.SQLException;

/**
 *
 * @author buse
 */
public interface AdminPermissions 
{
    public void listAllAcc() throws ClassNotFoundException, SQLException;
    public void listAllBooks() throws ClassNotFoundException, SQLException;
    public void deleteMember() throws ClassNotFoundException, SQLException;
    public void deleteBook() throws ClassNotFoundException, SQLException;
    public String addUser();
    public String addBook();
    public void Menu();
  
}
