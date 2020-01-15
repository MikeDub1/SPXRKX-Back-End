package com.indies.sprx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.http.MediaType;
import java.util.*;

import java.util.ArrayList;

/*
*
*@author: mduboc
*
*/ 

@RestController
public class RestCtrlMain
{
    @Autowired
    JdbcTemplate jdbc_connector; //Connect to MySQL using JDBC.

@RequestMapping(value = "/latestPurchases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public String latestPurchases(@RequestParam(required = false) Integer numListRecentPurchases)
{
    if(numListRecentPurchases == null) {numListRecentPurchases = 2;}
    jdbc_connector.execute("DROP TABLE IF EXISTS Sometable");

    return "Success!";
}
}