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
public class Product {
    private String prodID;
    private String prodName;
    private String noProd;

    public Product(String prodID, String prodName, String noProd) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.noProd = noProd;
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getNoProd() {
        return noProd;
    }

    public void setNoProd(String noProd) {
        this.noProd = noProd;
    }
    
    
    
}
