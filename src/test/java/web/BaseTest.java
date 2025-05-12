package web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import web.drivers.DriverManager;
import web.helpers.TestListener;
import web.steps.*;
import static web.constans.UrlConfig.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestListener.class)
public class BaseTest {
    protected LoginSteps loginSteps;
    protected RecoverySteps recoverySteps;

    public BaseTest() {

    }

    protected void open(String pageUrl) {
        DriverManager.getDriver()
                .get(BASE_URL + pageUrl);
    }

    @BeforeEach
    public void driverInitialization() {
        WebDriver driver = DriverManager.getDriver();
        refreshPages(driver);
    }

    @AfterEach
    public void clearCache() {
        DriverManager.resetDriver();
    }

    private void refreshPages(WebDriver driver) {
        loginSteps = new LoginSteps(driver);
        recoverySteps = new RecoverySteps();
    }
}