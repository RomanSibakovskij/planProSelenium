package lt.techin.example;

import org.junit.jupiter.api.Test;

public class NavigationToRegisterPageTest extends TestMethods{

    //Test 1 -> sign up link test
    @Test
    void clickSignUpLinkTests(){
        clickSignUpLinkTest();
    }

    //Test 2 -> register new account test
    @Test
    void registerNewAccountTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetails();

        registerNewAccountSubmissionTest(registerPage);

    }

    //Test 2a -> register attempt with too short username
    @Test
    void registerNewAccountTooShortUsernameTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithTooShortUsername();

        registerNewAccountTooShortUsernameTest(registerPage);

    }
    // Test 2b -> register attempt with no username
    @Test
    void registerNewAccountNoUsernameTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithNoUsername();

        registerNewAccountNoUsernameTest(registerPage);
    }

    //Test 2c -> register attempt with invalid email address
    @Test
    void registerNewAccountInvalidEmailTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithInvalidEmailAddress();

        registerNewAccountInvalidEmailTest(registerPage);
    }

    // Test 2d -> register attempt with no email address
    @Test
    void registerNoEmailTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithNoEmailAddress();

        registerNewAccountNoEmailTest(registerPage);
    }

    // Test 2e -> register attempt with invalid password
    @Test
    void registerNewAccountWithInvalidPasswordTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithInvalidPassword();

        registerNewAccountWithInvalidPasswordTest(registerPage);
    }

    // Test 2f -> register attempt with no password/confirm password
    @Test
    void registerNewAccountWithNoPasswordTest(){
        clickSignUpLinkTest();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithNoPassword();

        registerNewAccountWithNoPasswordTest(registerPage);
    }
    // Test 2g -> register attempt with mismatching passwords
    @Test
    void registerNewAccountWithMismatchingPasswordTest(){
        clickSignUpLinkTest();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetailsWithMismatchingPasswords();

        registerNewAccountWithMismatchingPasswordTest(registerPage);
    }
}
