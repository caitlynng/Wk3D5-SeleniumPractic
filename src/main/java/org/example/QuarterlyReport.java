package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuarterlyReport {
    private static WebDriver driver;

    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigate to the web page
        driver.get("file:///Users/catmin/Documents/Revature/Projects/Wk3D5-SeleniumPractice/240422JwA/week02/day05/XPath-Hero/quarterly-report.html");

        // Select only the second table
        WebElement secondTable = driver.findElement(By.xpath("(//table)[2]"));
        // Print some information about the second table
        System.out.println("Second Table Information:");
        System.out.println("Number of rows in the table: " + secondTable.findElements(By.tagName("tr")).size());
        System.out.println("Content of the first cell in the first row: " + secondTable.findElement(By.xpath(".//tr[1]/td[1]")).getText());


        // Select all trs where the attribute data-leader="Margaret"
        System.out.println("TRs where data-leader='Margaret':");
        for (WebElement tr : secondTable.findElements(By.xpath(".//tr[@data-leader='Margaret']"))) {
            System.out.println(tr.getText());
        }

        // Select all the tds containing the sales where Westview Middle was the troop
        System.out.println("TDs containing sales where Westview Middle was the troop:");
        for (WebElement td : secondTable.findElements(By.xpath(".//td[text()='Westview Middle']/parent::tr/td[2]"))) {
            System.out.println(td.getText());
        }

        // Select the last tr of Thin Mints in the first half
        WebElement firstHalfThinMintsLastTR = driver.findElement(By.xpath("//h2[text()='2021 1st half']/following-sibling::div//tr[.//td[text()='Thin Mints']][last()]"));
        System.out.println("Last TR of Thin Mints in the first half:");
        System.out.println(firstHalfThinMintsLastTR.getText());

        // Close the browser
        driver.quit();
    }
}
