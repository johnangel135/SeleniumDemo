package com.duong.demo.testcases;

import com.duong.demo.helper.TestData;
import com.duong.demo.webdriver.IWebDriverFacade;

public class LoginChrome extends Login{
    private final String DATA_PATH = "testdata/loginchrome.csv";

    @Override
    void init(){
        TestData.readData(DATA_PATH);
    }
}
