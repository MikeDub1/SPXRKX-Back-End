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

    private int OrderNum = 0;
    private int ProductNum;
    private int ProductQuantity;
    private int ProductPrice;
    
    private String SellerName;
    private String ProductName;
    private String ProductDescription;
    private String ProductFlavor;

    public Product(int order, int PNum, int PQuantity, int PPrice,
            String SellrName, String PName, String PDescription, String PFlavor) {
        ProductNum = PNum;
        ProductQuantity = PQuantity;
        ProductPrice = PPrice;
        SellerName = SellrName;
        ProductName = PName;
        ProductDescription = PDescription;
        ProductFlavor = PFlavor;
    }

    public void setOrderNum(int NewOrderNum) {
        OrderNum = NewOrderNum;
    }

    public int getProductNum() {
        return ProductNum;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public String getSellerName() {
        return SellerName;
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
