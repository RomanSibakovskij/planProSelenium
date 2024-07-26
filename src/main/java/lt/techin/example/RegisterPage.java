package lt.techin.example;

import lt.techin.example.TestDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage {

    //elements
    @FindBy(css = "input[name='name']")
    private WebElement usernameInputField;

    @FindBy(css = "input[name='email']")
    private WebElement emailAddressInputField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInputField;

    @FindBy(css = "input[name='repeatPassword']")
    private WebElement confirmPasswordInputField;

    //buttons
    @FindBy(xpath = "//div[@id='root']//form/button[@type='submit']")
    private WebElement createAnAccountButton;

    //input data
    private String username;
    private String emailAddress;
    private String password;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public void inputNewUserDetails(){
        username = TestDataGenerator.generateRandomUsername(8);
        emailAddress = TestDataGenerator.generateRandomEmailAddress(10);
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("Username: " + username);
        System.out.println("Email: " + emailAddress);
        System.out.println("Password: " + password + "\n");


    }

    //input methods
    public void inputNewUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys(username);
    }

    public void inputNewEmailAddress() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(emailAddressInputField));
        emailAddressInputField.sendKeys(emailAddress);
    }

    public void inputNewPassword() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        passwordInputField.sendKeys(password);
    }

    public void inputConfirmPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        confirmPasswordInputField.sendKeys(password);
    }

    public void clickCreateAnAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(createAnAccountButton));
        createAnAccountButton.click();
    }



    //assert methods
    public boolean isUsernameInputFieldPresent(){
        return usernameInputField.isDisplayed();
    }

    public boolean isEmailAddressInputFieldPresent(){
        return emailAddressInputField.isDisplayed();
    }

    public boolean isPasswordInputFieldPresent(){
        return passwordInputField.isDisplayed();
    }

    public boolean isConfirmPasswordInputFieldPresent(){
        return confirmPasswordInputField.isDisplayed();
    }

    public boolean isCreateAnAccountButtonPresent(){
        return createAnAccountButton.isDisplayed();
    }

    //getters for email / password

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
