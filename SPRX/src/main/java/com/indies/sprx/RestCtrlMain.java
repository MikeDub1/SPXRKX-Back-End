package com.indies.sprx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

/*
*
*@author: mduboc
*
*/ 

@RestController
public class RestCtrlMain
{
//Connect to MySQL using JDBC.

@RequestMapping(value = "/latestPurchases", method = GET)
public ArrayList<RecentPurchase> latestPurchases(int n)
{
    //....Handles latestPurchases requests.
}
}