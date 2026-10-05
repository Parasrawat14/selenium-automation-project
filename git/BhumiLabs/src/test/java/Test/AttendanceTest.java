package Test;

import org.testng.annotations.Test;

import Base.Basetest;
import Page.AttendancePage;
import Testcase.login1;

public class AttendanceTest extends Basetest

{
	@Test
public void attendancetest() 
{

	login1 login = new login1();
	login.login();
	
	AttendancePage att = new AttendancePage(driver);
	
	
    att.clickattendance();
    att.date();
    att.todate();
    att.employeeid();
}
}




