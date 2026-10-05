package Test;

import org.testng.annotations.Test;

import Base.Basetest;
import Page.loginpage;

public class LoginTest extends Basetest {

    @Test
    public void loginTest() {

        loginpage loginPage = new loginpage(driver);

        loginPage.login("MG00001", "MG00001");
    }
}