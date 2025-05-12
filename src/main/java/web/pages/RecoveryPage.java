package web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static web.helpers.Waiters.waitElement;

public class RecoveryPage extends BasePage {

    @FindBy(xpath = "//input[@name='loginOrEmail']")
    private WebElement loginRecovery;
    @FindBy(xpath = "//a[@class='mira-page-forgot-password-link']")
    private  WebElement backButton;
    @FindBy(xpath = "//button[@class='mira-page-forgot-password-button']")
    private WebElement sendButton;
    @FindBy(xpath = "//div[@class ='success']")
    private WebElement success;


    public boolean clickEmailAndSend(String Login) {
        waitElement(loginRecovery);
        loginRecovery.click();
        loginRecovery.sendKeys(Login);
        waitElement(sendButton);
        sendButton.click();
        waitElement(success);
        return success.isDisplayed();
    }
    public void isBackButton() {
        waitElement(backButton);
        backButton.click();
    }



}
