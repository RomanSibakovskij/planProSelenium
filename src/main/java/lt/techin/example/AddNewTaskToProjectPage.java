package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddNewTaskToProjectPage extends BasePage {

    //elements

    @FindBy(xpath = "//*//input[@id='name']")
    private WebElement taskNameInputField;

    @FindBy(xpath = "//*//textarea[@id='description']")
    private WebElement taskDescriptionInputField;

    @FindBy(xpath = "//*//div[@id='root']/div//button[.='Add task']")
    private WebElement addTaskButton;

    @FindBy(xpath = "//*[contains(text(), 'Name must be at least 2 characters long.')]")
    private WebElement tooShortNameMessage;

    @FindBy(xpath = "//*[contains(text(), 'Name must be maximum 50 characters long.')]")
    private WebElement tooLongNameMessage;

    @FindBy(xpath = "//*[contains(text(), 'No email provided')]")
    private WebElement tooShortDescriptionMessage;

    @FindBy(xpath = "//*[contains(text(), 'No email provided')]")
    private WebElement tooLongDescriptionMessage;

    @FindBy(css = "select#priority")
    private WebElement taskPriorityDropdownMenu;

    @FindBy(css = "select#priority > option[value='low']")
    private WebElement lowPrioritySelector;

    @FindBy(css = "select#priority > option[value='medium']")
    private WebElement mediumPrioritySelector;

    @FindBy(css = "select#priority > option[value='high']")
    private WebElement highPrioritySelector;

    @FindBy(css = "img[alt='Task status bubble']")
    private List<WebElement> taskStatusIcons;

    @FindBy(css = "img[alt='Priority Icon']")
    private List<WebElement> taskPriorityIcons;

    //link, buttons

    @FindBy(xpath = "//div[@id='root']/nav//a[@href='/']")
    private WebElement planProButton;

    @FindBy(css = "div > a:nth-of-type(2)")
    private WebElement projectLink;
    @FindBy(xpath = "//div[@id='root']//form/button[@type='submit']")
    private WebElement submitButton;

    public AddNewTaskToProjectPage(WebDriver driver) {
        super(driver);
    }

    private String taskName;
    private String taskDescription;

    // Data input method
    public void generateTaskDetails() {
        this.taskName = TestDataGenerator.generateRandomTaskName(15);
        this.taskDescription = TestDataGenerator.generateRandomTaskDescription(21);

        System.out.println("Generated Data:");
        System.out.println("Task name: " + taskName);
        System.out.println("Task description: " + taskDescription + "\n");
    }

    // Getters
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getTaskStatusIconCount(){
        return taskStatusIcons.size();
    }
    public int getTaskPriorityIconCount(){
        return taskPriorityIcons.size();
    }

    // Input methods
    public void inputTaskDetails() {
        inputTaskName();
        inputTaskDescription();
    }

    public void inputTaskName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskNameInputField));
        if (taskName != null && !taskName.isEmpty()) {
            taskNameInputField.sendKeys(this.taskName);
        } else {
            throw new IllegalArgumentException("Task name is null or empty.");
        }
    }

    public void inputTaskDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskDescriptionInputField));
        if (taskDescription != null && !taskDescription.isEmpty()) {
            taskDescriptionInputField.sendKeys(this.taskDescription);
        } else {
            throw new IllegalArgumentException("Task description is null or empty.");
        }
    }

    //negative input methods
    public void inputTaskNoNameDetails() {
        inputTaskNoName();
        inputTaskDescription();
    }

    public void inputTaskNoName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskNameInputField));
        taskNameInputField.sendKeys("");
    }

    public void inputTaskTooShortNameDetails() {
        inputTaskTooShortName();
        inputTaskDescription();
    }

    public void inputTaskTooShortName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskNameInputField));
        taskNameInputField.sendKeys("L");
    }

    public void inputTaskTooLongNameDetails() {
        inputTaskTooLongName();
        inputTaskDescription();
    }

    public void inputTaskTooLongName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskNameInputField));
        taskNameInputField.sendKeys("sfsdfdsfdfsdfsdfsdfsdfsdfdfsdfsffasdsadadsafsdgdff");
    }



    public void inputTaskNoDescriptionDetails() {
        inputTaskName();
        inputTaskNoDescription();
    }

    public void inputTaskNoDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(taskNameInputField));
        taskNameInputField.sendKeys("");
    }

    public void selectPriorityHighStatus(){
        taskPriorityDropdownMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(highPrioritySelector));
        highPrioritySelector.click();
    }

    //methods
    public void clickPlanProButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(planProButton));
        planProButton.click();
    }

    public void clickProjectLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(projectLink));
        projectLink.click();
    }

    public void clickAddTaskButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(addTaskButton));
        addTaskButton.click();
    }

    public void clickSubmitTaskButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }



    //assert methods
    public boolean isPlanProButtonPresent() {
        return planProButton.isDisplayed();
    }

    public boolean isProjectLinkPresent() {
        return projectLink.isDisplayed();
    }
    public boolean isAddTaskButtonPresent() {
        return addTaskButton.isDisplayed();
    }
    public boolean isTaskNameInputFieldPresent() {
        return taskNameInputField.isDisplayed();
    }
    public boolean isTaskDescriptionInputFieldPresent() {
        return taskDescriptionInputField.isDisplayed();
    }
    public boolean isTaskPriorityDropdownMenuPresent() {
        return taskPriorityDropdownMenu.isDisplayed();
    }
    public boolean isSubmitTaskButtonPresent() {
        return submitButton.isDisplayed();
    }

    public boolean isAnyTaskStatusIconsDisplayed(){
        for(WebElement icon : taskStatusIcons){
            if(icon.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public void printAllTaskStatusIconsDetails(){
        for(WebElement icon : taskStatusIcons){
            if(icon.isDisplayed()){
                System.out.println("In-progress icons found: " + icon.getAttribute("alt"));
            }
        }
    }

    public boolean isAnyTaskPriorityIconsDisplayed(){
        for(WebElement icon : taskPriorityIcons){
            if(icon.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public void printAllTaskPriorityIconsDetails(){
        for(WebElement icon : taskPriorityIcons){
            if(icon.isDisplayed()){
                System.out.println("In-progress icons found: " + icon.getAttribute("alt"));
            }
        }
    }

    //getters

    public String getTooShortNameMessage(){
        return tooShortNameMessage.getText();
    }

    public String getTooLongNameMessage(){
        return tooLongNameMessage.getText();
    }
}
