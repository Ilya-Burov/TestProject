package web.helpers;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeSelected;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static web.drivers.DriverManager.getDriver;

public class Waiters {

    public static final int TIME_TO_WAIT = 10;

    public static WebElement waitElement(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(TIME_TO_WAIT))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static Alert waitAlertElement() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(TIME_TO_WAIT))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.alertIsPresent());
    }


}
