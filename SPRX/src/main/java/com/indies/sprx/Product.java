/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indies.sprx;

/**
 *
 * @author mians
 */
 
public class Product {
    
 
    private int ProductNum;

    private String ProductName;
    private String ProductDescription;
    private String ProductFlavor;

    public Product(int PNum, String PName, String PDescription, String PFlavor) {
        ProductNum = PNum;
        ProductName = PName;
        ProductDescription = PDescription;
        ProductFlavor = PFlavor;
    }

    public int getProductNum() {
        return ProductNum;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public String getProductFlavor() {
        return ProductFlavor;
    }

}
