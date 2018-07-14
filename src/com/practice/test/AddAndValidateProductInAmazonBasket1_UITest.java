package com.practice.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import com.commonlib.ReportingLib;
import com.practice.testlib.BaseTest;
import com.practice.testlib.Login;

public class AddAndValidateProductInAmazonBasket1_UITest extends BaseTest{
	@Before
	public void invalidUNErrormsg()
	{
		report.startReport();
		
     }
	@Test
	public void invalidPswNErrormsg() throws Exception
	{
		login.loginToAmazon("F1", "UC1", "TC1", false, 3);

     }

	@After
	public void addValidateProduct()
	{
		report.endReport();

	}
}
