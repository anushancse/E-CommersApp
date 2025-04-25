package locaters;

import StepDefinations.Hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sign_Up_Locate {
    WebDriver driver = Hooks.driver;
    // Locators and actions for login functionality

    public WebElement signupB() {

        return driver.findElement(By.xpath("//*[@id=\"signin2\"]"));
       
    }

    public WebElement username() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sign-username\"]"))).click();

        return driver.findElement(By.xpath("//*[@id=\"sign-username\"]"));
    }

    public WebElement password() {

        return driver.findElement(By.xpath("//*[@id=\"sign-password\"]"));
    }

    public WebElement signupButton() {
        return driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
    }

    public WebElement loginB() {

        return driver.findElement(By.xpath("//*[@id=\"login2\"]"));
    }

    public WebElement usernameL() {

        return driver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
    }

    public WebElement passwordL() {

        return driver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
    }

    public WebElement loginButton() {

        return driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
    }
}