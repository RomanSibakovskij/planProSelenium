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

}
