package Test;

import org.testng.annotations.Test;

import Base.Basetest;
import Page.Regularizeform;
import Testcase.login1;

public class Regularizetest extends Basetest 

{
	@Test
	 public void addEmployee() {

	        // Login
	        login1 login = new login1();
	        login.login();
	        
	        Regularizeform rg = new Regularizeform(driver);
	        
	        rg.clickonattendance();
	        rg.clickregularize();
	        rg.select();
	      
	}
}
