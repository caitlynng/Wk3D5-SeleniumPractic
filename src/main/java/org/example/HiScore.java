package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiScore {
    private static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigate to the web page
        driver.get("file:///Users/catmin/Documents/Revature/Projects/Wk3D5-SeleniumPractice/240422JwA/week02/day05/XPath-Hero/hi-score.html");

        // Get the li that contains TIM's Dig Dug score
        WebElement timDigDugScore = driver.findElement(By.xpath("//li[contains(text(), 'TIM') and contains(text(), 'Dig Dug')]"));
        System.out.println("TIM's Dig Dug score: " + timDigDugScore.getText());

        // Get the list items that belong to YVN or GAR
        System.out.println("List items belonging to YVN or GAR:");
        for (WebElement element : driver.findElements(By.xpath("//li[contains(text(), 'YVN') or contains(text(), 'GAR')]"))) {
            System.out.println(element.getText());
        }

        // Get the total amount of li in the document
        int totalLiCount = driver.findElements(By.tagName("li")).size();
        System.out.println("Total amount of li in the document: " + totalLiCount);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Close the browser
        driver.quit();
    }
}
