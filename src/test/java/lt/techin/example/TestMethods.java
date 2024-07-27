package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMethods extends BaseTest{

    //protected test methods

    protected void clickSignUpLinkTest() {
        LoginPage loginPage = new LoginPage(driver);
        //assert sign up link is displayed
        assertTrue(loginPage.isSignUpLinkPresent(), "Sign up link is not present" + "\n");
        System.out.println("Sign up link is present" + "\n");
        loginPage.clickSignUpLink();
    }

    protected static void registerNewAccountSubmissionTest(RegisterPage registerPage) {
        //assert the username input field is displayed
        assertTrue(registerPage.isUsernameInputFieldPresent(), "Username input field is not present" + "\n");
        System.out.println("Username input field is present" + "\n");
        registerPage.inputNewUsername();

        //assert the email address input field is present
        assertTrue(registerPage.isEmailAddressInputFieldPresent(), "Email address input field is not present" + "\n");
        System.out.println("Email address input field is present" + "\n");
        registerPage.inputNewEmailAddress();

        //assert the password input field is present
        assertTrue(registerPage.isPasswordInputFieldPresent(), "Password input field is not present" + "\n");
        System.out.println("Password input field is present" + "\n");
        registerPage.inputNewPassword();

        //assert the confirm password input field is present
        assertTrue(registerPage.isConfirmPasswordInputFieldPresent(), "Confirm password input field is not present" + "\n");
        System.out.println("Confirm password input field is present" + "\n");
        registerPage.inputConfirmPassword();

        //assert the 'Create an Account' button is present
        assertTrue(registerPage.isCreateAnAccountButtonPresent(), "Create an account button is not present" + "\n");
        System.out.println("Create an account button is present" + "\n");
        registerPage.clickCreateAnAccountButton();
    }

    protected void loginAsRegisteredUserTest(RegisterPage registerPage) {
        LoginPage loginPage = new LoginPage(driver);
        //assert email address input field is displayed
        assertTrue(loginPage.isEmailAddressInputFieldPresent(), "Email address input field is not present" + "\n");
        System.out.println("Email address input field is present" + "\n");
        loginPage.inputEmailAddress(registerPage.getEmailAddress());

        //assert password input field is displayed
        assertTrue(loginPage.isPasswordInputFieldPresent(), "Password input field is not present" + "\n");
        System.out.println("Password input field is present" + "\n");
        loginPage.inputPassword(registerPage.getPassword());

        //assert sign in button is displayed
        assertTrue(loginPage.isSigninButtonPresent(), "Sign in button is not present" + "\n");
        System.out.println("Sign in button is present");
        loginPage.clickSignInButton();
    }

    // login verification method with registered credentials
    protected void loginAsARegisteredUserTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputNewUserDetails();

        registerNewAccountSubmissionTest(registerPage);

        loginAsRegisteredUserTest(registerPage);
    }

    protected void registeredUserNavigationToProjectsTest() {
        ProjectDashboardPage projectDashboardPage = new ProjectDashboardPage(driver);

        //assert the manage your projects link is present
        assertTrue(projectDashboardPage.isProjectsLinkPresent(), "The projects link isn't present" + "\n");
        System.out.println("The projects link is present" + "\n");

        //assert the projects button is displayed on the navbar
        assertTrue(projectDashboardPage.isProjectsNavBarButtonPresent(), "The projects button isn't present on navbar" + "\n");
        System.out.println("The projects button is present on navbar" + "\n");
        projectDashboardPage.clickProjectsNavBarButton();
    }

    protected void addNewProjectTest() {
        AddNewProjectPage addNewProjectPage = new AddNewProjectPage(driver);

        //assert in-progress icons are displayed before new project creation
        assertInProgressIconsAreDisplayed(addNewProjectPage);
        //assert the 'Add project' button is displayed
        assertTrue(addNewProjectPage.isAddProjectButtonPresent(), "The 'Add project' button is not present" + "\n");
        System.out.println("The 'Add project' button is present" + "\n");
        addNewProjectPage.clickAddProjectButton();

        // project details
        addNewProjectPage.generateProjectDetails();

        //assert the project name and description input fields are displayed
        assertTrue(addNewProjectPage.isProjectNameInputPresent(), "The project name input field isn't present" + "\n");
        System.out.println("The project name input field is present" + "\n");
        assertTrue(addNewProjectPage.isProjectDescriptionInputPresent(), "The project description input field isn't present" + "\n");
        System.out.println("The project description input field is present" + "\n");

        addNewProjectPage.inputProjectDetails();

        //assert the 'Submit' button is displayed
        assertTrue(addNewProjectPage.isSubmitButtonPresent(), "The 'Submit' button is not present" + "\n");
        System.out.println("The 'Submit' button is present" + "\n");
        addNewProjectPage.clickSubmitButton();

        if(addNewProjectPage.isNextPageButtonPresent()){
            addNewProjectPage.clickNextPageButton();
        }

        //assert in-progress icons are displayed after new project creation
        assertInProgressIconsAreDisplayed(addNewProjectPage);
    }

    protected void addNewTaskToProjectTest() {
        AddNewTaskToProjectPage addNewTaskToProjectPage = new AddNewTaskToProjectPage(driver);
        //assert planpro button is displayed
        assertTrue(addNewTaskToProjectPage.isPlanProButtonPresent(), "The planpro button isn't present" + "\n");
        System.out.println("The planpro button is present" + "\n");
        addNewTaskToProjectPage.clickPlanProButton();
        //assert project link is displayed
        assertTrue(addNewTaskToProjectPage.isProjectLinkPresent(), "The project link isn't present" + "\n");
        System.out.println("The project link is present" + "\n");
        addNewTaskToProjectPage.clickProjectLink();

        //assert task status and priority icons are displayed before task submission
        assertTaskStatusIconsAreDisplayed(addNewTaskToProjectPage);
        assertTaskPriorityIconsAreDisplayed(addNewTaskToProjectPage);

        //assert add task button is displayed
        assertTrue(addNewTaskToProjectPage.isAddTaskButtonPresent(), "The add task button isn't present" + "\n");
        System.out.println("The add task button is present" + "\n");
        addNewTaskToProjectPage.clickAddTaskButton();

        //task details
        addNewTaskToProjectPage.generateTaskDetails();

        //assert task name and task description input fields are displayed
        assertTrue(addNewTaskToProjectPage.isTaskNameInputFieldPresent(), "The task name input field isn't present" + "\n");
        System.out.println("The task name input field is present" + "\n");
        assertTrue(addNewTaskToProjectPage.isTaskDescriptionInputFieldPresent(), "The task description input field isn't present" + "\n");
        System.out.println("The task description input field is present" + "\n");

        addNewTaskToProjectPage.inputTaskDetails();

        //assert priority dropdown menu is present
        assertTrue(addNewTaskToProjectPage.isTaskPriorityDropdownMenuPresent(), "The task priority dropdown menu isn't present" + "\n");
        System.out.println("The task priority dropdown menu is present" + "\n");
        addNewTaskToProjectPage.selectPriorityHighStatus();

        //assert 'Submit' button is present
        assertTrue(addNewTaskToProjectPage.isSubmitTaskButtonPresent(), "The submit button isn't present" + "\n");
        System.out.println("The submit button is present" + "\n");
        addNewTaskToProjectPage.clickSubmitTaskButton();

        //assert task status and priority icons are displayed after task submission
        assertTaskStatusIconsAreDisplayed(addNewTaskToProjectPage);
        assertTaskPriorityIconsAreDisplayed(addNewTaskToProjectPage);
    }

    protected void editNewTaskTest() {
        EditNewTaskPage editNewTaskPage = new EditNewTaskPage(driver);

        //assert 'Edit task' button is present
        assertTrue(editNewTaskPage.isEditTaskButtonPresent(), "The 'Edit task' button isn't present" + "\n");
        System.out.println("The 'Edit task' button is present" + "\n");
        editNewTaskPage.clickEditTaskButton();

        editNewTaskPage.generateEditedTaskDetails();

        //assert the task name and description fields are present
        assertTrue(editNewTaskPage.isEditTaskInputFieldPresent(), "The edited task name input field isn't present" + "\n");
        System.out.println("The edited task name input field is present" + "\n");
        assertTrue(editNewTaskPage.isEditTaskDescriptionInputFieldPresent(), "The edited task description input field isn't present" + "\n");
        System.out.println("The edited task description input field is present" + "\n");

        //edit the task name and description
        editNewTaskPage.inputEditedTaskDetails();

        //assert status dropdown menu is present
        assertTrue(editNewTaskPage.isStatusDropdownMenuPresent(), "The status dropdown menu isn't present" + "\n");
        System.out.println("The status dropdown menu is present" + "\n");
        editNewTaskPage.selectStatusDropdownMenu();

        //assert priority dropdown menu is present
        assertTrue(editNewTaskPage.isPriorityDropdownMenuPresent(), "The task priority dropdown menu isn't present" + "\n");
        System.out.println("The task priority dropdown menu is present" + "\n");
        editNewTaskPage.selectPriorityMediumStatus();

        //assert 'Submit' button is displayed
        assertTrue(editNewTaskPage.isEditedTaskSubmitButtonPresent(), "The 'Submit' button isn't present" + "\n");
        System.out.println("The 'Submit' button is present" + "\n");
        editNewTaskPage.submitEditTaskButtonClick();
    }

    protected void editProjectTest() {
        EditNewProjectPage editNewProjectPage = new EditNewProjectPage(driver);
        //assert 'Edit project' button is present
        assertTrue(editNewProjectPage.isEditProjectButtonPresent(), "The 'Edit project' button isn't present" + "\n");
        System.out.println("The 'Edit project' button is present" + "\n");
        editNewProjectPage.clickEditProjectButton();

        editNewProjectPage.generateEditedProjectDetails();
        //edit the project name and description
        editNewProjectPage.inputEditedProjectDetails();

        //assert 'Submit' button is displayed
        assertTrue(editNewProjectPage.isSubmitButtonPresent(), "The 'Submit' button isn't present" + "\n");
        System.out.println("The 'Submit' button is present" + "\n");
        editNewProjectPage.clickSubmitButton();
    }

    //private test methods
    private void assertInProgressIconsAreDisplayed(AddNewProjectPage addNewProjectPage) {
        //assert in-progress icons are displayed
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1450));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("img[alt='Project status bubble']")
            ));

            // number of progress status icons
            int iconCount = addNewProjectPage.getProjectStatusIconCount();
            System.out.println("Number of in-progress icons found: " + iconCount);

            // check if any progress status icon are displayed
            if (addNewProjectPage.isAnyProgressStatusIconsDisplayed()) {
                System.out.println("At least one in-progress icon is displayed.");
            } else {
                System.out.println("No in-progress icons are displayed.");
            }
            addNewProjectPage.printAllProgressStatusIconsDetails();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void assertTaskStatusIconsAreDisplayed(AddNewTaskToProjectPage addNewTaskToProjectPage) {
        //assert task status icons are displayed
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(850));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("img[alt='Task status bubble']")
            ));

            // number of task status icons
            int iconCount = addNewTaskToProjectPage.getTaskStatusIconCount();
            System.out.println("Number of task status icons found: " + iconCount);

            // check if any task status icons are displayed
            if (addNewTaskToProjectPage.isAnyTaskStatusIconsDisplayed()) {
                System.out.println("At least one task status icon is displayed.");
            } else {
                System.out.println("No task status icons are displayed.");
            }
            addNewTaskToProjectPage.printAllTaskStatusIconsDetails();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void assertTaskPriorityIconsAreDisplayed(AddNewTaskToProjectPage addNewTaskToProjectPage) {
        //assert task priority icons are displayed
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(850));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("img[alt='Priority Icon']")
            ));

            // number of task status icons
            int iconCount = addNewTaskToProjectPage.getTaskPriorityIconCount();
            System.out.println("Number of task priority icons found: " + iconCount);

            // check if any task status icons are displayed
            if (addNewTaskToProjectPage.isAnyTaskPriorityIconsDisplayed()) {
                System.out.println("At least one task priority icon is displayed.");
            } else {
                System.out.println("No task priority icons are displayed.");
            }
            addNewTaskToProjectPage.printAllTaskPriorityIconsDetails();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
