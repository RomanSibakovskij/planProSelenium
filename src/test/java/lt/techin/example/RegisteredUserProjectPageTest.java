package lt.techin.example;

import org.junit.jupiter.api.Test;

public class RegisteredUserProjectPageTest extends TestMethods{

    //Test 3 -> login into account as registered user
    @Test
    void loginAsRegisteredUserTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
    }

    //Test 3a -> login attempt with invalid email address
    @Test
    void loginAsRegisteredUserWithInvalidEmailTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserInvalidEmailTest();
    }

    //Test 3b -> login attempt with invalid password
    @Test
    void loginAsRegisteredUserWithInvalidPasswordTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserInvalidPasswordTest();
    }

    //Test 3c -> login attempt with no email address
    @Test
    void loginAsRegisteredUserNoEmailTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserNoEmailTest();
    }

    //Test 3d -> login attempt with no password
    @Test
    void loginAsRegisteredUserNoPasswordTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserNoPasswordTest();
    }

    //Test 4 -> registered user navigation to projects page
    @Test
    void registeredUserNavigationToProjectsTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
    }
}
