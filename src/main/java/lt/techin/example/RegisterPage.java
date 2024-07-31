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

    @FindBy(xpath = "//*[contains(text(), 'Username is required and must be between 6 and 32 characters')]")
    private WebElement invalidUsernameMessage;

    @FindBy(css = "input[name='email']")
    private WebElement emailAddressInputField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[contains(text(), 'Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character')]")
    private WebElement invalidPasswordMessage;

    @FindBy(css = "#root > div > form > div:nth-child(4) > p")
    private WebElement mismatchingPasswordsMessage;

    @FindBy(css = "input[name='repeatPassword']")
    private WebElement confirmPasswordInputField;

    //buttons
    @FindBy(xpath = "//div[@id='root']//form/button[@type='submit']")
    private WebElement createAnAccountButton;

    //input data
    private String username;
    private String shortUsername;
    private String noUsername = "";
    private String emailAddress;
    private String invalidEmailAddress;
    private String noEmailAddress = "";
    private String password;
    private String invalidPassword;
    private String noPassword = "";

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

    public void inputNewUserDetailsWithTooShortUsername(){
        shortUsername = TestDataGenerator.generateRandomUsername(1);
        emailAddress = TestDataGenerator.generateRandomEmailAddress(10);
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("Too short username: " + shortUsername);
        System.out.println("Email: " + emailAddress);
        System.out.println("Password: " + password + "\n");
    }

    public void inputNewUserDetailsWithNoUsername(){
        noUsername = "";
        emailAddress = TestDataGenerator.generateRandomEmailAddress(10);
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("No username: " + noUsername);
        System.out.println("Email: " + emailAddress);
        System.out.println("Password: " + password + "\n");
    }

    public void inputNewUserDetailsWithInvalidEmailAddress(){
        username = TestDataGenerator.generateRandomUsername(8);
        invalidEmailAddress = TestDataGenerator.generateRandomInvalidEmailAddress(10);
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("Username: " + username);
        System.out.println("Invalid email: " + invalidEmailAddress);
        System.out.println("Password: " + password + "\n");
    }

    public void inputNewUserDetailsWithNoEmailAddress(){
        username = TestDataGenerator.generateRandomUsername(8);
        noEmailAddress = "";
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("Username: " + username);
        System.out.println("No email: " + noEmailAddress);
        System.out.println("Password: " + password + "\n");
    }

    public void inputNewUserDetailsWithInvalidPassword(){
        username = TestDataGenerator.generateRandomUsername(8);
        emailAddress = TestDataGenerator.generateRandomEmailAddress(10);
        invalidPassword = TestDataGenerator.generateRandomInvalidPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("Username: " + username);
        System.out.println("Email: " + emailAddress);
        System.out.println("Invalid password: " + invalidPassword + "\n");
    }

    public void inputNewUserDetailsWithNoPassword(){
        username = TestDataGenerator.generateRandomUsername(8);
        emailAddress = TestDataGenerator.generateRandomEmailAddress(10);
        noPassword = "";

        System.out.println("Generated Data:" + "\n");
        System.out.println("Username: " + username);
        System.out.println("Email: " + emailAddress);
        System.out.println("No password: " + noPassword + "\n");
    }

    public void inputNewUserDetailsWithMismatchingPasswords(){
        username = TestDataGenerator.generateRandomUsername(8);
        emailAddress = TestDataGenerator.generateRandomEmailAddress(10);
        password = TestDataGenerator.generateRandomPassword();
        invalidPassword = TestDataGenerator.generateRandomInvalidPassword();

        System.out.println("Generated Data:" + "\n");
        System.out.println("Username: " + username);
        System.out.println("Email: " + emailAddress);
        System.out.println("Password: " + password);
        System.out.println("Confirm password: " + invalidPassword + "\n");
    }

    //input methods
    public void inputNewUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys(username);
    }

    public void inputTooShortUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(emailAddressInputField));
        usernameInputField.sendKeys(shortUsername);
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

    //invalid inputs (email, password)

    public void inputInvalidEmailAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(emailAddressInputField));
        emailAddressInputField.sendKeys(invalidEmailAddress);
    }

    public void inputNewInvalidPassword() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        passwordInputField.sendKeys(invalidPassword);
    }

    public void inputInvalidConfirmPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        confirmPasswordInputField.sendKeys(invalidPassword);
    }

    public void inputNoPassword() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        passwordInputField.sendKeys(noPassword);
    }

    public void inputNoConfirmPassword() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        passwordInputField.sendKeys(noPassword);
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

    //negative test cases getters

    public String getNoUsername() {
        return noUsername;
    }

    public String getInvalidEmailAddress(){
        return invalidEmailAddress;
    }

    public String getNoEmailAddress() {
        return noEmailAddress;
    }

    public String getNoPassword(){
        return noPassword;
    }

    public String getInvalidUsernameMessage() {
        return invalidUsernameMessage.getText();
    }

    public String getInvalidPasswordMessage(){
        return invalidPasswordMessage.getText();
    }

    public String getMismatchingPasswordMessage(){
        return mismatchingPasswordsMessage.getText();
    }
}
