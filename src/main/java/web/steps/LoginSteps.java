package web.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    public LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Переход на окно при забытии пароля")
    public LoginSteps clickRegistrationButton() {
        loginPage.clickForgetPasswordButton();
        return this;
    }

    @Step("Нажатие на кнопку показать пароль")
    public void clickPasswordButton() {
        loginPage.clickShowPasswordButton();

    }

    @Step("Нажатие на кнопку входа")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("Нажать на поле Логин и ввести её")
    public void enterLogin(String Login) {
        loginPage.clickLogin(Login);
    }
    @Step("Нажать на поле Логин и ввести её")
    public void forgetLogin() {
        loginPage.clickForgetPasswordButton();
    }

    @Step("Нажать на поле Пароль и ввести его")
    public void enterPassword(String Password) {
        loginPage.clickPassword(Password);
    }
    @Step("Нажать на поле Пароль, ввести и проверить работу кнопки показать пароль")
    public void checkButtonShowPassword(String Password) {
        assertEquals("1P73BP4Z",loginPage.clickShowPassword(Password));
    }
    @Step("Проверка успешного входа")
    public void checkLogin(){
        assertTrue(loginPage.isLoginSuccessful());
    }
    @Step("Проверка возникновения ошибки")
    public void checkError(){
        assertTrue(loginPage.isError());
    }
    @Step("Проверка  ошибки, не связанной с пустыми полями")
    public void checkErrorFormat(){
        assertTrue(loginPage.isErrorIncorrectFormat());
    }


}
