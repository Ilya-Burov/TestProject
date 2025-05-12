package web.pages;

import io.netty.handler.timeout.TimeoutException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.helpers.Waiters.waitElement;
import static web.helpers.Waiters.waitAlertElement;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='user']")
    private WebElement login;
    @FindBy(xpath = "//input[@name = 'password']")
    private  WebElement password;
    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@id='show_password']")
    private WebElement showPasswordButton;
    @FindBy(xpath = "//a[@class='mira-default-login-page-link']")
    private WebElement forgetPasswordButton;
    @FindBy(xpath = "//div[@title = 'Новости']")
    private WebElement title;
    private final WebDriver driver;
    private Alert alert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        waitElement(loginButton);
        loginButton.click();
    }

    public void clickForgetPasswordButton() {
        waitElement(forgetPasswordButton);
        forgetPasswordButton.click();
    }

    public void clickShowPasswordButton() {
        waitElement(showPasswordButton);
        showPasswordButton.click();
    }

    public void clickLogin(String Login) {
        waitElement(login);
        login.click();
        login.sendKeys(Login);
    }

    public void clickPassword(String Password) {
        waitElement(password);
        password.click();
        password.sendKeys(Password);
    }
    public String clickShowPassword(String Password) {
        waitElement(password);
        password.click();
        password.sendKeys(Password);
        showPasswordButton.click();
        String pass = password.getAttribute("value");
        System.out.println(pass);
        return pass;
    }

    public boolean isLoginSuccessful(){
        waitElement(title);
        return title.isDisplayed();
    }

    public boolean isError() {
        Alert alert = waitAlertElement();
        String errorText = alert.getText();
        System.out.println(errorText);
        return errorText.equals("Неверные данные для авторизации.");

    }
    public boolean isErrorIncorrectFormat() {
        Alert alert = waitAlertElement();
        String errorText = alert.getText();
        System.out.println(errorText);
        return errorText.equals("Неверные данные для авторизации");

    }

    }

