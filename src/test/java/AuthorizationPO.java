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

    @FindBy(css ="#header-lk-button")
    private WebElement clikcBTN;

    public void login(){
        clikcBTN.click();
    }
}
