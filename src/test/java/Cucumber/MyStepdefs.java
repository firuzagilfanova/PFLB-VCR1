package Cucumber;

import Config.EnvConfig;
import UI_UXCrowd.AuthorizationPO;
import UI_UXCrowd.TestUI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
public static EnvConfig envConfig;
public static AuthorizationPO authorizationPO;
    public static WebDriver driver;

   @Before
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
        envConfig = new EnvConfig();

        authorizationPO = new AuthorizationPO(driver);

    }

    @Дано("Пользователь заходит на главную страницу")
    public void пользовательЗаходитНаГлавнуюСтраницу() {
        driver.get(envConfig.baseUrl);
    }

    @И("нажимает кнопку войти")
    public void нажимаетКнопкуВойти() {
       authorizationPO.login();
    }

    @И("вводит логин login")
    public void вводитЛогинLogin() {
       authorizationPO.setLogin(envConfig.username);
    }

    @И("вводит пароль pasword")
    public void вводитПарольPasword() {
       authorizationPO.setPassword(envConfig.userPassword);
    }

    @И("нажимает кнопку вход")
    public void нажимаетКнопкуВход() {
       authorizationPO.setLogBTN();
    }

@After
public void driverQuit() {
    driver.close();
    driver.quit();
}
}
