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

    @FindBy(xpath = "//*[contains(text(), 'Incorrect email or password. Please try again.')]")
    private WebElement invalidInputMessage;

    @FindBy(xpath = "//*[contains(text(), 'Email is required')]")
    private WebElement noEmailMessage;

    @FindBy(xpath = "//*[contains(text(), 'Password is required')]")
    private WebElement noPasswordMessage;

    //link, button

    @FindBy(xpath = "//*//div[@id='root']//form/button[@type='submit']")
    private WebElement signinButton;

    @FindBy(xpath = "//*//div[@id='root']/nav/div/div[2]/div/a[@href='/']")
    private WebElement accountButton;

    @FindBy(xpath = "//*//div[@id='root']//form//a[@href='/registration']")
    private WebElement signUpLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/div/div[2]/div/div/div/p")
    private WebElement logoutLink;

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

    public void clickLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public void clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(signinButton));
        signinButton.click();
    }

    public void clickAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        accountButton.click();
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

    public boolean isAccountButtonPresent(){
        return accountButton.isDisplayed();
    }

    public boolean isLogoutLinkPresent(){
        return logoutLink.isDisplayed();
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
