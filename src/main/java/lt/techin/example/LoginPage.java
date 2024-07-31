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

    @FindBy(css = "#root > div > div.sc-gFqAYk.ixfqVX > div > form > p")
    private WebElement invalidInputMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/form/div[1]/p")
    private WebElement noEmailMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/form/div[2]/p")
    private WebElement noPasswordMessage;

    //link, button

    @FindBy(xpath = "//*//div[@id='root']//form/button[@type='submit']")
    private WebElement signinButton;

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

    //invalid inputs
    public void inputInvalidEmailAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressInputField));
        emailAddressInputField.sendKeys("m3@example.com");
    }

    public void inputNoEmailAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressInputField));
        emailAddressInputField.sendKeys("");
    }

    public void inputInvalidPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField));
        passwordInputField.sendKeys("Staker112_");
    }

    public void inputNoPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField));
        passwordInputField.sendKeys("");
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

    //getter

    public String getInvalidInputMessage() {
        return invalidInputMessage.getText();
    }

    public String getEmailRequiredMessage(){
        return noEmailMessage.getText();
    }

    public String getPasswordRequiredMessage(){
        return noPasswordMessage.getText();
    }
}
