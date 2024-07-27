package lt.techin.example;

import org.junit.jupiter.api.Test;

public class RegisteredUserProjectPageTest extends TestMethods{

    //Test 3 -> login into account as registered user
    @Test
    void loginAsRegisteredUserTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
    }

    //Test 4 -> registered user navigation to projects page
    @Test
    void registeredUserNavigationToProjectsTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
    }
}
