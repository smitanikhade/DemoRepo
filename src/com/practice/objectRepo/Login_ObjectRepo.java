package com.practice.objectRepo;

import org.openqa.selenium.By;

import com.practice.testlib.BaseTest;

public class Login_ObjectRepo{
	public static final By byYourOrders=By.xpath("//span[text()='Your Orders']/span[@class=\"nav-icon nav-arrow\"]");
	public static final By byEmail=By.xpath("//input[@type='email']");
	public static final By byContinueBtn=By.xpath("//input[@id='continue']");
	public static final By byUNErrorMsg=By.xpath("//div[@id=\"auth-error-message-box\"]");
	public static final By byPassword=By.xpath("//input[@type='password']");
	public static final By bySignInBtn=By.xpath("//input[@id='signInSubmit']");
	public static final By byPSWErrorMsg=By.xpath("//div[@id=\"auth-error-message-box\"]");
	public static final By bySignOutBtn=By.xpath("//span[text()='Sign Out']");
	public static final By byCartBtn=By.xpath("//span[@class=\"nav-cart-count nav-cart-1\"]");

}
