
package Test;

import org.testng.annotations.Test;

import Base.Basetest;
import Page.AddEmployeePage;
import Testcase.login1;

public class AddEmployeeTest extends Basetest {

    @Test
    public void addEmployee() {

        // Login
        login1 login = new login1();
        login.login();


        
        // Create Page Object
        AddEmployeePage employee =
                new AddEmployeePage(driver);


        // ================= PAGE 1 =================

        employee.openAddEmployee();

        employee.enterBasicDetails();

        employee.selectDOB();

        employee.selectJoiningDate();

        employee.enterContactDetails();

        employee.selectInTime();

        employee.selectOutTime();

        employee.selectEmployeeDetails();

        employee.clickNextPage1();


        // ================= PAGE 2 =================

        employee.enterPersonalDetails();

        employee.uploadProfilePhoto();

        employee.clickNextPage2();


        
        // ================= PAGE 3 =================

        employee.enterAadhar();

        employee.clickNextPage3();


        // ================= PAGE 4 =================

        employee.uploadAddressProof();

      //  employee.clickSubmit();
    }
}

