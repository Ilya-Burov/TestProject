package web.steps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.pages.RecoveryPage;
import web.pages.RecoveryPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RecoverySteps {
    public RecoveryPage recoveryPage;
    public LoginSteps loginSteps;

    public RecoverySteps() {
        recoveryPage = new RecoveryPage();
    }
    @Step("Нажать на поле Логин и ввести её")
    public void enterLogin(String Login) {
        assertTrue(recoveryPage.clickEmailAndSend(Login));}
    @Step("Проверить кнопку назад")
    public void clickBackButton() {
        recoveryPage.isBackButton();}

}
