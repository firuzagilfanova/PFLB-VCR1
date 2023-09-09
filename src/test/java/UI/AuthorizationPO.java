package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPO {
    private WebDriver driver;


    public AuthorizationPO(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"header-lk-button\"]")
    private WebElement clikcBTN;
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"form_auth\"]/input[2]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"form_auth\"]/button")
    private WebElement logBTN;

    public void login(){
        clikcBTN.click();
    }
    public void setLogin(String loginClient){
        login.sendKeys(loginClient);
    }
    public void setPassword(String passw){
        password.sendKeys(passw);
    }
    public void setLogBTN(){
        logBTN.click();
    }
}
