/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_1;

/**
 *
 * @author buse
 */
public abstract class User 
{
    public String userName;
    int password;
    
    public User(String username, int password)
    {
        this.password=password;
        this.userName=username;
    }
 
}


