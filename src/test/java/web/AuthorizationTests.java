package web;

import org.junit.jupiter.api.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tags({@Tag("Web"), @Tag("MVP")})
@Epic("[CUST]US-1.1 Регистрация клиента в приложении")
@DisplayName("[CUST]US-1.1 Регистрация клиента в приложении")
public class AuthorizationTests extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        open("");
    }

    @DisplayName("Проверка авторизации при пустом логине и валидном пароле")
    @Description("Данный тест-кейс проверяет авторизацию при наличии пустого поля Login")
    @Tags({@Tag("Negative")})
    @ParameterizedTest
    @CsvSource({"'', 1P73BP4Z"})
    public void emptyLoginEnterTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkError();
    }
    @DisplayName("Проверка авторизации при пустом пароле и валидном логине")
    @Description("Данный тест-кейс проверяет авторизацию при наличии пустых полей Login Password или обоих")
    @Tags({@Tag("Negative")})
    @ParameterizedTest
    @CsvSource({"1P73BP4Z, ''"})
    public void emptyPasswordEnterTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkError();
    }
    @DisplayName("Проверка авторизации при пустых полях")
    @Description("Данный тест-кейс проверяет авторизацию при наличии пустых полей Login и Password")
    @Tags({@Tag("Negative")})
    @ParameterizedTest
    @CsvSource({"'', ''"})
    public void emptyFieldsEnterTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkError();
    }


    @DisplayName("Проверка успещной авторизации")
    @Description("Данный тест-кейс проверяет авторизацию при введении валидных данных")
    @Tags({@Tag("Positive")})
    @ParameterizedTest
    @CsvSource({"fominaelena,1P73BP4Z"})

    public void successEnterTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkLogin();
    }
    @DisplayName("Проверка авторизации при некорректных форматах данных")
    @Description("Данный тест-кейс проверяет авторизацию при наличии спецсимволов, пробелов в тексте полей и кириллицы")
    @Tags({@Tag("Negative")})
    @ParameterizedTest
    @CsvSource({"fomina@#lena, 1P73BP4Z","fominaelena, 1p73bp4z ",
            "fominaelena, 1P73B@P4Z","fomina elena, 1p73bp4z", "fominaelena, 1p7  3bp4z","фоминаелена, 1P73B@P4Z" })
    public void incorrectFormatEnterTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkErrorFormat();
    }
    @DisplayName("Проверка авторизации при пробелах наличии пробелов ")
    @Description("Данный тест-кейс проверяет авторизацию при начальных пробелах в логине и пароле")
    @Tags({@Tag("Positive")})
    @ParameterizedTest
    @CsvSource({"  fominaelena,1P73BP4Z","  fominaelena,   1P73BP4Z","fominaelena,  1P73BP4Z ","FOMINAELENA, 1P73BP4Z " })
    public void spaceEnterTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkLogin();
    }
    @DisplayName("Проверка авторизации при верхнем регистре поля Login ")
    @Description("Данный тест-кейс проверяет авторизацию при верхнем регистре логина")
    @Tags({@Tag("Positive")})
    @ParameterizedTest
    @CsvSource({ "FOMINAELENA, 1P73BP4Z" })
    public void LoginHighTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
        loginSteps.checkLogin();
    }
    @DisplayName("Проверка корректного отображения пароля при нажатии на кнопку показать символы ")
    @Description("Данный тест-кейс проверяет корректное отображение ")
    @Tags({@Tag("Positive")})
    @ParameterizedTest
    @CsvSource({ "fominaelena, 1P73BP4Z" })
    public void showCorrectPasswordTest(String Login, String Password) {
        loginSteps.enterLogin(Login);
        loginSteps.checkButtonShowPassword(Password);
    }
    @DisplayName("Проверка восстановления пароля ")
    @Description("Данный тест-кейс проверяет полный путь до восстановления пароля ")
    @Tags({@Tag("Positive")})
    @ParameterizedTest
    @CsvSource({ "fominaelena" })
    public void showCorrectRecovery(String Login) {
        loginSteps.forgetLogin();
        recoverySteps.enterLogin(Login);
    }
    @DisplayName("Проверка кнопки назад")
    @Description("Данный тест-кейс проверяет работу кнопки назад ")
    @Tags({@Tag("Positive")})
    @ParameterizedTest
    @CsvSource({ "fominaelena, 1P73BP4Z" })
    public void showCorrectRecovery(String Login, String Password) {
        loginSteps.forgetLogin();
        recoverySteps.clickBackButton();
        loginSteps.enterLogin(Login);
        loginSteps.enterPassword(Password);
        loginSteps.clickLoginButton();
    }



}
