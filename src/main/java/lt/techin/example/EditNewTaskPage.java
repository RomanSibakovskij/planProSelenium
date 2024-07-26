package lt.techin.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditNewTaskPage extends BasePage{

    //elements

    @FindBy(xpath = "//*//input[@id='name']")
    private WebElement taskNameInputField;

    @FindBy(xpath = "//*//textarea[@id='description']")
    private WebElement taskDescriptionInputField;

    @FindBy(xpath = "//*//select[@id='status']")
    private WebElement statusSelectorDropdownMenu;

    @FindBy(css = "select#status > option[value='in-progress']")
    private WebElement statusInProgressSelector;

    @FindBy(css = "select#priority")
    private WebElement prioritySelectorDropdownMenu;

    @FindBy(css = "select#priority > option[value='medium']")
    private WebElement mediumPrioritySelector;

    //buttons
    @FindBy(xpath = "//div[@id='root']//form/button[@type='submit']")
    private WebElement submitEditTaskButton;

    @FindBy(css = "p > a")
    private WebElement editTaskButton;


    public EditNewTaskPage(WebDriver driver) {
        super(driver);
    }

    private String editedTaskName;
    private String editedTaskDescription;

    public void generateEditedTaskDetails() {
        this.editedTaskName = TestDataGenerator.generateRandomTaskName(15);
        this.editedTaskDescription = TestDataGenerator.generateRandomTaskDescription(21);

        System.out.println("Generated Data:");
        System.out.println("Edited task name: " + editedTaskName);
        System.out.println("Edited task description: " + editedTaskDescription);
    }

    // Getters
    public String getEditedTaskName() {
        return editedTaskName;
    }

    public String getEditedTaskDescription() {
        return editedTaskDescription;
    }

    // Input methods
    public void inputEditedTaskDetails() {
        inputEditedTaskName();
        inputEditedTaskDescription();
    }

    public void inputEditedTaskName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskNameInputField));
        if (editedTaskName != null && !editedTaskName.isEmpty()) {
            taskNameInputField.clear();
            taskNameInputField.sendKeys(this.editedTaskName);
        } else {
            taskNameInputField.sendKeys(this.editedTaskName);
        }
    }

    public void inputEditedTaskDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskDescriptionInputField));
        if (editedTaskDescription != null && !editedTaskDescription.isEmpty()) {
            taskDescriptionInputField.clear();
            taskDescriptionInputField.sendKeys(this.editedTaskDescription);
        } else {
            taskDescriptionInputField.sendKeys(this.editedTaskDescription);
        }
    }

    public void selectStatusDropdownMenu() {
        statusInProgressSelector.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(statusInProgressSelector));
        statusInProgressSelector.click();
    }

    public void selectPriorityMediumStatus(){
        prioritySelectorDropdownMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(mediumPrioritySelector));
        mediumPrioritySelector.click();
    }

    //click methods
    public void clickEditTaskButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1250));
        wait.until(ExpectedConditions.visibilityOf(editTaskButton));
        editTaskButton.click();
    }

    public void submitEditTaskButtonClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1250));
        wait.until(ExpectedConditions.visibilityOf(submitEditTaskButton));
        submitEditTaskButton.click();
    }


    //assert methods
    public boolean isEditTaskButtonPresent(){
        return editTaskButton.isDisplayed();
    }

    public boolean isEditTaskInputFieldPresent(){
        return taskNameInputField.isDisplayed();
    }

    public boolean isEditTaskDescriptionInputFieldPresent(){
        return taskDescriptionInputField.isDisplayed();
    }

    public boolean isStatusDropdownMenuPresent(){
        return statusSelectorDropdownMenu.isDisplayed();
    }

    public boolean isPriorityDropdownMenuPresent(){
        return prioritySelectorDropdownMenu.isDisplayed();
    }

    public boolean isEditedTaskSubmitButtonPresent(){
        return submitEditTaskButton.isDisplayed();
    }
}
