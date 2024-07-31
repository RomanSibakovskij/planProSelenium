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
    //Test 5b -> add new project with too short name
    @Test
    void addNewProjectTooShortNameTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithTooShortNameTest();
    }

    //Test 5c -> add new project with too long name
    @Test
    void addNewProjectTooLongNameTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithTooLongNameTest();
    }

    //Test 5d -> add new project with no description
    @Test
    void addNewProjectNoDescriptionTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithNoDescriptionTest();
    }

    //Test 5e -> add new project with no description
    @Test
    void addNewProjectTooShortDescriptionTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithTooShortDescriptionTest();
    }

    //Test 5f -> add new project with no description
    @Test
    void addNewProjectTooLongDescriptionTest(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectWithTooLongDescriptionTest();
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

    // Test 6b -> add new task with too short name
    @Test
    void addNewTaskWithTooShortNameToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithTooShortNameTest();
    }

    // Test 6c -> add new task with too long name
    @Test
    void addNewTaskWithTooLongNameToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithTooLongNameTest();
    }

    // Test 6d -> add new task with no description to the project

    @Test
    void addNewTaskWithNoDescriptionToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithNoDescriptionTest();
    }

    // Test 6e -> add new task with no description to the project

    @Test
    void addNewTaskWithTooShortDescriptionToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithTooShortDescriptionTest();
    }

    // Test 6f -> add new task with no description to the project

    @Test
    void addNewTaskWithTooLongDescriptionToProjectTests(){
        clickSignUpLinkTest();
        loginAsARegisteredUserTest();
        registeredUserNavigationToProjectsTest();
        addNewProjectTest();
        addNewTaskToProjectWithTooLongDescriptionTest();
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
