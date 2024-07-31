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

    //Test 5a -> add new project with no name
    @Test
    void addNewProjectNoNameTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithNoNameTest();
    }
    //Test 5b -> add new project too short name
    @Test
    void addNewProjectTooShortNameTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithTooShortNameTest();
    }

    //Test 5b -> add new project with no description
    @Test
    void addNewProjectNoDescriptionTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithNoDescriptionTest();
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

    // Test 6a -> add new task with no name to the project

    @Test
    void addNewTaskWithNoNameToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithNoNameTest();
    }

    // Test 6b -> add new task with no description to the project

    @Test
    void addNewTaskWithNoDescriptionToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithNoDescriptionTest();
    }

    // Test 7 -> edit new project task test

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
