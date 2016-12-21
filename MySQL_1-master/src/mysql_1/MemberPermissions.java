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
public interface MemberPermissions 
{   
    public void listAllMyBooks() throws ClassNotFoundException, SQLException;
    public void searchBook() throws ClassNotFoundException, SQLException;
    public int findBookId(String bookName) throws ClassNotFoundException, SQLException;
    public void commentBook() throws ClassNotFoundException, SQLException;
    public void borrowBook();
    public void Menu();   
}
