/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

/**
 *
 * @author User
 */
public class SiteManager extends Person{
    private String fname;
    private String lname;
    private String email;
    private String phone;  

    public SiteManager(String fname, String lname, String email, String phone, String username, String password, String userType) {
        super(username, password, userType);
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }
    
    
}

