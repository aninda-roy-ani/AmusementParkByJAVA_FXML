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
public class ProductAdd extends Product {
    
    private String issueDate;
    private String supplier;

    public ProductAdd(String prodID, String prodName, String noProd, String issueDate, String supplier) {
        super(prodID, prodName, noProd);
        this.issueDate = issueDate;
        this.supplier = supplier;
    }
    
    
}
