package locaters;

import StepDefinations.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProducts_Locate {

    WebDriver driver= Hooks.driver;


    public WebElement LaptopIcon()  {

        return driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"));
    }
    public WebElement Product1Laptops(){

        return driver.findElement(By.linkText("Sony vaio i5"));
    }
    public WebElement AddToCard1()  {

        return driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a"));
    }
    public WebElement CartButton1 (){

        return driver.findElement(By.xpath("//li[@class=\"nav-item\"]//a[@id=\"cartur\"]"));
    }

    public WebElement Product2Laptops(){

        return driver.findElement(By.linkText("Sony vaio i7"));
    }
    public WebElement AddToCard2 (){

        return driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a"));
    }
    public WebElement CartButton2 () {

        return driver.findElement(By.xpath("//li[@class=\"nav-item\"]//a[@id=\"cartur\"]"));
    }


    }