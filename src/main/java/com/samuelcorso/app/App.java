package com.samuelcorso.app;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/samuelcorso/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.linkedin.com");

        WebElement emailInput = driver.findElement(By.id("login-email"));
        emailInput.sendKeys("pearlsplpstudent@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("login-password"));
        passwordInput.sendKeys(Constants.getPassword());
        passwordInput.submit();

        WebElement profileButton = driver.findElement(By.cssSelector(
                "a[class='tap-target profile-rail-card__actor-link block link-without-hover-visited ember-view'"));
        profileButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement scrollToElement = driver.findElement(By.id("oc-background-section"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement showMoreButton = driver.findElement(By.cssSelector(
                "button[class='pv-profile-section__card-action-bar pv-skills-section__additional-skills artdeco-container-card-action-bar'"));
        showMoreButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<WebElement> skillsElements;
        skillsElements = driver
                .findElements(By.cssSelector("span[class='pv-skill-category-entity__name-text t-16 t-black t-bold'"));

        for (int i = 0; i < skillsElements.size(); i++) {
            try {
                System.out.println(skillsElements.get(i).getText());
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            }
        }

        driver.quit();
    }
}
