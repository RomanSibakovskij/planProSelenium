package lt.techin.example;

import org.junit.jupiter.api.Test;

public class RegisteredUserProjectPageManagementTest extends TestMethods{

    //Test 5 -> add new project

    // add pagination elements when project count is above 12
    @Test
    void addNewProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
    }

    // Test 6 -> add new task to the project

    @Test
    void addNewTaskToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectTest();
    }

    // Test 7 -> edit new project task

    @Test
    void editNewProjectTaskTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectTest();
        editNewTaskTest();
    }

    // Test 8 -> edit new project test
    @Test
    void editNewProjectTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        editProjectTest();
    }

}
