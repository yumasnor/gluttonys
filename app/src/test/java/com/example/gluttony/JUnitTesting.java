package com.example.gluttony;

import com.example.gluttony.BLL.LoginBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JUnitTesting {

@Test
    public void loginTest(){
    LoginBLL bll = new LoginBLL("Bikal", "bikal");
    boolean result = bll.checkUser();
    assertEquals(true,result);
}
}
