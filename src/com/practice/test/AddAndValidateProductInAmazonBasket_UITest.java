package com.practice.test;

import org.testng.annotations.Test;
import com.practice.testlib.BaseTest;

public class AddAndValidateProductInAmazonBasket_UITest extends BaseTest{


		@Test(priority=0)
	public void invalidUNErrormsg()
	{
			login.loginToAmazon("F1", "UC1", "TC1", false, 1);
     }
	@Test
	public void invalidPswNErrormsg()
	{
		login.loginToAmazon("F1", "UC1", "TC1", false, 2);
     }

	@Test
	public void addValidateProduct()
	{
		login.loginToAmazon("F1", "UC1", "TC1", false, 3);

		/*String productName=selectAndAddProduct.selectAndAddProduct();
			login.logout();
			login.loginToAmazon(3);
			selectAndAddProduct.validateproductInBasket(productName);
			login.logout();*/
	}

}