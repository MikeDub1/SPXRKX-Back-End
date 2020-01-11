package com.indies.sprx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import java.util.Date;

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

@RequestMapping(value = "/latestPurchases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public static RecentPurchase latestPurchases()
{
    RecentPurchase rp = new RecentPurchase("juul purple", "Michael Duboc", new Date());
    return rp;
}
}