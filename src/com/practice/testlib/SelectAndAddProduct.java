package com.practice.testlib;
import java.util.Iterator;
import org.junit.Assert;
import static com.practice.objectRepo.SelectAndAddProduct_ObjectRepo.*;

public class SelectAndAddProduct extends BaseTest{/*
	public String selectAndAddProduct()
	{
		String actProductName=null;
		try {
			driver.findElement(bySearchBox).sendKeys("iphone x 64 gb");
			driver.findElement(bySearchBtn).click();
			driver.findElement(bySearchResult).click();
			String getProductName=driver.findElement(byProductName).getText();
			String price=driver.findElement(byPrice).getText();

			String parent=driver.getWindowHandle();
			Iterator<String> itr=driver.getWindowHandles().iterator();
			while(itr.hasNext())
			{
				String child=itr.next();
				if(!parent.equals(child))
				{
					driver.switchTo().window(child);
				}
			}
			driver.findElement(byAddToCartBtn).click();
			String actAddToCartMsg=driver.findElement(byCartMsg).getText();
            String expAddToCartMsg="Added to Cart";
            boolean result=actAddToCartMsg.equals(expAddToCartMsg);
            Assert.assertTrue("Product is added to cart successfully", result);
			driver.findElement(byCartBtn).click();
			actProductName=driver.findElement(byProductNmInCart).getText();
			String actPrice=driver.findElement(byPriceInCart).getText();
            boolean compareProductName=getProductName.equals(actProductName);
            boolean comparePrice=price.equals(actPrice);
			Assert.assertTrue("Product is verified successfully", compareProductName);
			Assert.assertTrue("Price is verified successfully", comparePrice);


		}
		catch(Exception e)
		{
			System.out.println("Exception occurred");

		}
		return actProductName;
	}
	public void validateproductInBasket(String expProductName)
	{
		try
		{
			driver.findElement(byCartBtn).click();
			String actProductName=driver.findElement(byProductNmInCart).getText();
            boolean compareProductName=expProductName.equals(actProductName);
			Assert.assertTrue("Product is verified successfully", compareProductName);
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred");

		}
	}
*/}
