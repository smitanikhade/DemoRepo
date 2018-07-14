package com.practice.objectRepo;

import org.openqa.selenium.By;

public class SelectAndAddProduct_ObjectRepo {
public static final By bySearchBox=By.xpath("//input[@id=\"twotabsearchtextbox\"]");
public static final By bySearchBtn=By.xpath("//input[@type=\"submit\" and @class='nav-input']");
public static final By bySearchResult=By.xpath("//ul[@id=\"s-results-list-atf\"]/li[1]/div/div[1]");
public static final By byProductName=By.xpath("//span[@id=\"productTitle\"]");
public static final By byPrice=By.xpath("//span[@id=\"priceblock_ourprice\"]");
public static final By byAddToCartBtn=By.xpath("//input[@id=\"add-to-cart-button\"]");
public static final By byCartMsg=By.xpath("//div[@id=\"huc-v2-order-row-confirm-text\"]/h1");
public static final By byCartBtn=By.xpath("//span[@class=\"nav-cart-count nav-cart-1\"]");
public static final By byProductNmInCart=By.xpath("//div[@class=\"sc-list-body\"]//span[@class=\"a-size-medium sc-product-title a-text-bold\"]");
public static final By byPriceInCart=By.xpath("//div[@class=\"a-column a-span2 a-text-left\"]/p[1]/span");

}
