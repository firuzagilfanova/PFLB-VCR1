package Cucumber;

import Config.EnvConfig;
import UI_UXCrowd.AuthorizationPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TariffsStepdefs {
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

    @Дано("Пользователь переходит на главную страницу")
    public void пользовательПереходитНаГлавнуюСтраницу() {
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

    @И("вводит пароль password")
    public void вводитПарольPassword() {
        authorizationPO.setPassword(envConfig.userPassword);
    }

    @И("нажимает кнопку вход")
    public void нажимаетКнопкуВход() {
        authorizationPO.setLogBTN();
    }

    @И("нажимает кнопку профиль")
    public void нажимаетКнопкуПрофиль() {
        authorizationPO.setProfileBTN();
    }

    @И("нажимает кнопку перейти к тарифам")
    public void нажимаетКнопкуПерейтиКТарифам() {
        authorizationPO.setGoToTariffsBTN();
    }

    @И("нажимает кнопку изменить тариф")
    public void нажимаетКнопкуИзменитьТариф() {
        authorizationPO.setChangeTariffToIndividBTN();
    }

    @И("нажимает кнопку получить счет на оплату")
    public void нажимаетКнопкуПолучитьСчетНаОплату() {
        authorizationPO.setGetInvoiceBTN();
    }

    @After
    public void driverQuit() {
        driver.close();
        driver.quit();
    }
}