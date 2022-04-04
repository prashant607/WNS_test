package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
//         Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.get("https://www.moneycorp.com/en-gb/");

        WebElement closeBanner = driver.findElement(By.xpath("//div[@class='addthis_bar_x icon-arrow-up']"));
        closeBanner.click();

        WebElement languageDropdown = driver.findElement(By.id("language-dropdown-flag"));
        languageDropdown.click();

        WebElement usaLanguage = driver.findElement(By.xpath("//a[@aria-label='USA English']"));
        usaLanguage.click();

        //waiting for 30 seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement coockieClose = driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']/button"));
        coockieClose.click();


        WebElement findMoreButton = driver.findElement(By.xpath("//*[text()='Foreign exchange solutions']/../a"));
        findMoreButton.click();

        //waiting for 10 seconds for the page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement search = driver.findElement(By.xpath("//button[@aria-label='Search']"));
        search.click();

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='nav_search']"));
        searchInput.sendKeys("international payments");
        searchInput.sendKeys(Keys.RETURN);

        if(driver.getPageSource().contains("international payments"))
        {
            System.out.println("Correct page is displayed!");
        }

        else
        {
            System.out.println("Incorrect page is displayed!");
        }

        List<WebElement> links = driver.findElements(By.xpath("//a[@class='title']"));


        for (WebElement webElement : links) {

            String printLinkText = webElement.getAttribute("href");
            assert printLinkText.contains("https://www.moneycorp.com/en-us/");
            System.out.println(printLinkText);

        }

        driver.close();


    }

}
