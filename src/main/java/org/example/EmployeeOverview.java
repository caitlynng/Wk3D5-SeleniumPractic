package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeOverview {
    private static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigate to the web page
        driver.get("file:///Users/catmin/Documents/Revature/Projects/Wk3D5-SeleniumPractice/240422JwA/week02/day05/XPath-Hero/employee-overview.html");

        // Select all tds that have a money sign in them
        System.out.println("Tds with money sign:");
        for (WebElement element : driver.findElements(By.xpath("//td[contains(text(), '$')]"))) {
            System.out.println(element.getText());
        }

        // Get the first tr in the tbody
        WebElement firstTR = driver.findElement(By.xpath("//tbody/tr[position()=1]"));
        System.out.println("First tr in tbody:");
        System.out.println(firstTR.getText());

        // Get the last tr in the tbody
        WebElement lastTR = driver.findElement(By.xpath("//tbody/tr[last()]"));
        System.out.println("Last tr in tbody:");
        System.out.println(lastTR.getText());

        // Get all tds where the id is between 200 and 300
        System.out.println("Tds where id is between 200 and 300:");
        for (WebElement element : driver.findElements(By.xpath("//td[@id >= '200' and @id <= '300']"))) {
            System.out.println(element.getText());
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Close the browser
        driver.quit();
    }
}
