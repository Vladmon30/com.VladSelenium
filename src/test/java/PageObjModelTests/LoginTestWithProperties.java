package PageObjModelTests;

import org.testng.annotations.Test;
import utilities.Config;


public class LoginTestWithProperties {

@Test
public void readPropertiesTest(){
    String browsLogTestWProp = Config.getProperty("browserLogTestWProp");

    // Config --> utility folder "Config"
    // getProperty --> its a method what inside utility "Config" folder
    // browserLogTestWProp --> its a data inside config.properties folder what we save like key-->value
    //              ''browserLogTestWProp  = chrome''

    System.out.println(browsLogTestWProp);   //chrome

    String urlLogTestWProp = Config.getProperty("urlLogTestWProp");
    //urlLogTestWProp = http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx

    System.out.println(urlLogTestWProp);



}
}
