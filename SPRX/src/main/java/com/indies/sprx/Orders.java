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
public class Orders {
    
    private int OrderNum;
    private int ProductNum;
    private int ProductQuantity;
    private int ProductPrice;
    
    private String Status;
    private String SellerName;
    private String ProductName;
    private String ProductDescription;
    private String ProductFlavor;

  public Orders(int PNum,int PQuantity,int PPrice, 
          String SellrName, String PName, String PDescription ,String PFlavor){

    ProductNum = PNum;
    ProductQuantity=PQuantity;
    ProductPrice=PPrice;
    SellerName=SellrName;
    ProductName=PName;
    ProductDescription=PDescription;
    ProductFlavor=PFlavor;
    }

    
}
