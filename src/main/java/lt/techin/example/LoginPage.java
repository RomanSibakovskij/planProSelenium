package lt.techin.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    //elements
    @FindBy(css = "input[name='login']")
    private WebElement emailAddressInputField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*//div[@id='root']//form/button[@type='submit']")
    private WebElement signinButton;

    //buttons
    @FindBy(xpath = "//*//div[@id='root']//form//a[@href='/registration']")
    private WebElement signUpLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //methods

    public void inputEmailAddress(String emailAddress){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressInputField));
        emailAddressInputField.sendKeys(emailAddress);
    }

    public void inputPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField));
        passwordInputField.sendKeys(password);
    }

    //button, link

    public void clickSignUpLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink));
        signUpLink.click();
    }

    public void clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(signinButton));
        signinButton.click();
    }

    //assert methods
    public boolean isSignUpLinkPresent() {
        return signUpLink.isDisplayed();
    }

    public boolean isEmailAddressInputFieldPresent() {
        return emailAddressInputField.isDisplayed();
    }

    public boolean isPasswordInputFieldPresent() {
        return passwordInputField.isDisplayed();
    }

    public boolean isSigninButtonPresent() {
        return signinButton.isDisplayed();
    }

}
