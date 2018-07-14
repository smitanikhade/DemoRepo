
package com.practice.testlib;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.commonlib.AbstractUITest;
import com.commonlib.QATestRunner;
import com.commonlib.ReportingLib;

import com.practice.objectRepo.Login_ObjectRepo;
@RunWith(QATestRunner.class)
public class BaseTest extends AbstractUITest 
{
	protected static Login login=null;
	protected static SelectAndAddProduct selectAndAddProduct=null;
	protected static Login_ObjectRepo login_ObjectRepo=null;
	protected static Utility utility=null;
	//protected static WebDriver driver=null;
	protected static ReportingLib report=null;
	protected static final Logger LOG = Logger.getLogger(ReportingLib.class);
    @BeforeClass
    public static void initialize()
	{
		PropertyConfigurator.configure("Log4j.properties");
    	
		selectAndAddProduct=new SelectAndAddProduct();
		login_ObjectRepo=new Login_ObjectRepo();
		utility=new Utility();
		report=new ReportingLib();
		login=new Login();

	}
}
